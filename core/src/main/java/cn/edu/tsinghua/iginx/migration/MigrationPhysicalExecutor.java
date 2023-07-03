package cn.edu.tsinghua.iginx.migration;

import cn.edu.tsinghua.iginx.conf.ConfigDescriptor;
import cn.edu.tsinghua.iginx.engine.physical.exception.PhysicalException;
import cn.edu.tsinghua.iginx.engine.physical.memory.MemoryPhysicalTaskDispatcher;
import cn.edu.tsinghua.iginx.engine.physical.storage.execute.StoragePhysicalTaskExecutor;
import cn.edu.tsinghua.iginx.engine.physical.task.MemoryPhysicalTask;
import cn.edu.tsinghua.iginx.engine.physical.task.StoragePhysicalTask;
import cn.edu.tsinghua.iginx.engine.physical.task.TaskExecuteResult;
import cn.edu.tsinghua.iginx.engine.physical.task.UnaryMemoryPhysicalTask;
import cn.edu.tsinghua.iginx.engine.shared.data.read.Row;
import cn.edu.tsinghua.iginx.engine.shared.data.read.RowStream;
import cn.edu.tsinghua.iginx.engine.shared.data.write.RawData;
import cn.edu.tsinghua.iginx.engine.shared.data.write.RawDataType;
import cn.edu.tsinghua.iginx.engine.shared.data.write.RowDataView;
import cn.edu.tsinghua.iginx.engine.shared.operator.*;
import cn.edu.tsinghua.iginx.engine.shared.operator.filter.AndFilter;
import cn.edu.tsinghua.iginx.engine.shared.operator.filter.Filter;
import cn.edu.tsinghua.iginx.engine.shared.operator.filter.KeyFilter;
import cn.edu.tsinghua.iginx.engine.shared.operator.filter.Op;
import cn.edu.tsinghua.iginx.engine.shared.source.FragmentSource;
import cn.edu.tsinghua.iginx.engine.shared.source.OperatorSource;
import cn.edu.tsinghua.iginx.metadata.entity.FragmentMeta;
import cn.edu.tsinghua.iginx.metadata.entity.KeyInterval;
import cn.edu.tsinghua.iginx.metadata.entity.StorageUnitMeta;
import cn.edu.tsinghua.iginx.thrift.DataType;
import cn.edu.tsinghua.iginx.utils.Bitmap;
import cn.edu.tsinghua.iginx.utils.ByteUtils;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MigrationPhysicalExecutor {

    private static final MigrationPhysicalExecutor INSTANCE = new MigrationPhysicalExecutor();

    public static MigrationPhysicalExecutor getInstance() {
        return INSTANCE;
    }

    public RowStream execute(Migration migration, StoragePhysicalTaskExecutor storageTaskExecutor) throws PhysicalException {
        FragmentMeta toMigrateFragment = migration.getFragmentMeta();
        StorageUnitMeta targetStorageUnitMeta = migration.getTargetStorageUnitMeta();
        KeyInterval keyInterval = toMigrateFragment.getKeyInterval();
        List<String> paths = migration.getPaths();

        // 查询分区数据
        List<Operator> projectOperators = new ArrayList<>();
        Project project = new Project(new FragmentSource(toMigrateFragment), paths, null);
        projectOperators.add(project);
        StoragePhysicalTask projectPhysicalTask = new StoragePhysicalTask(projectOperators);

        List<Operator> selectOperators = new ArrayList<>();
        List<Filter> selectTimeFilters = new ArrayList<>();
        selectTimeFilters.add(new KeyFilter(Op.GE, keyInterval.getStartKey()));
        selectTimeFilters.add(new KeyFilter(Op.L, keyInterval.getEndKey()));
        selectOperators.add(
                new Select(new OperatorSource(project), new AndFilter(selectTimeFilters), null));
        MemoryPhysicalTask selectPhysicalTask =
                new UnaryMemoryPhysicalTask(selectOperators, projectPhysicalTask);
        projectPhysicalTask.setFollowerTask(selectPhysicalTask);

        storageTaskExecutor.commit(projectPhysicalTask);

        TaskExecuteResult selectResult = selectPhysicalTask.getResult();
        RowStream selectRowStream = selectResult.getRowStream();

        List<String> selectResultPaths = new ArrayList<>();
        List<DataType> selectResultTypes = new ArrayList<>();
        selectRowStream
                .getHeader()
                .getFields()
                .forEach(
                        field -> {
                            selectResultPaths.add(field.getName());
                            selectResultTypes.add(field.getType());
                        });

        List<Long> timestampList = new ArrayList<>();
        List<ByteBuffer> valuesList = new ArrayList<>();
        List<Bitmap> bitmapList = new ArrayList<>();
        List<ByteBuffer> bitmapBufferList = new ArrayList<>();

        boolean hasTimestamp = selectRowStream.getHeader().hasKey();
        while (selectRowStream.hasNext()) {
            Row row = selectRowStream.next();
            Object[] rowValues = row.getValues();
            valuesList.add(ByteUtils.getRowByteBuffer(rowValues, selectResultTypes));
            Bitmap bitmap = new Bitmap(rowValues.length);
            for (int i = 0; i < rowValues.length; i++) {
                if (rowValues[i] != null) {
                    bitmap.mark(i);
                }
            }
            bitmapBufferList.add(ByteBuffer.wrap(bitmap.getBytes()));
            bitmapList.add(bitmap);
            if (hasTimestamp) {
                timestampList.add(row.getKey());
            }

            // 按行批量插入数据
            if (timestampList.size()
                    == ConfigDescriptor.getInstance().getConfig().getMigrationBatchSize()) {
                insertDataByBatch(
                        timestampList,
                        valuesList,
                        bitmapList,
                        bitmapBufferList,
                        toMigrateFragment,
                        selectResultPaths,
                        selectResultTypes,
                        targetStorageUnitMeta.getId(), storageTaskExecutor);
                timestampList.clear();
                valuesList.clear();
                bitmapList.clear();
                bitmapBufferList.clear();
            }
        }
        insertDataByBatch(
                timestampList,
                valuesList,
                bitmapList,
                bitmapBufferList,
                toMigrateFragment,
                selectResultPaths,
                selectResultTypes,
                targetStorageUnitMeta.getId(), storageTaskExecutor);
        return selectResult.getRowStream();
    }

    private void insertDataByBatch(
            List<Long> timestampList,
            List<ByteBuffer> valuesList,
            List<Bitmap> bitmapList,
            List<ByteBuffer> bitmapBufferList,
            FragmentMeta toMigrateFragment,
            List<String> selectResultPaths,
            List<DataType> selectResultTypes,
            String storageUnitId, StoragePhysicalTaskExecutor storageTaskExecutor)
            throws PhysicalException {
        // 按行批量插入数据
        RawData rowData =
                new RawData(
                        selectResultPaths,
                        Collections.emptyList(),
                        timestampList,
                        ByteUtils.getRowValuesByDataType(valuesList, selectResultTypes, bitmapBufferList),
                        selectResultTypes,
                        bitmapList,
                        RawDataType.NonAlignedRow);
        RowDataView rowDataView =
                new RowDataView(rowData, 0, selectResultPaths.size(), 0, timestampList.size());
        List<Operator> insertOperators = new ArrayList<>();
        insertOperators.add(new Insert(new FragmentSource(toMigrateFragment), rowDataView));
        StoragePhysicalTask insertPhysicalTask = new StoragePhysicalTask(insertOperators);
        storageTaskExecutor.commitWithTargetStorageUnitId(insertPhysicalTask, storageUnitId);
        TaskExecuteResult insertResult = insertPhysicalTask.getResult();
        if (insertResult.getException() != null) {
            throw insertResult.getException();
        }
    }
}