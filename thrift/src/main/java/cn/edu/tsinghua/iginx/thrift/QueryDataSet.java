/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package cn.edu.tsinghua.iginx.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2021-03-16")
public class QueryDataSet implements org.apache.thrift.TBase<QueryDataSet, QueryDataSet._Fields>, java.io.Serializable, Cloneable, Comparable<QueryDataSet> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("QueryDataSet");

  private static final org.apache.thrift.protocol.TField TIMESTAMPS_FIELD_DESC = new org.apache.thrift.protocol.TField("timestamps", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField VALUES_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("valuesList", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField BITMAP_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("bitmapList", org.apache.thrift.protocol.TType.LIST, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new QueryDataSetStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new QueryDataSetTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer timestamps; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<java.nio.ByteBuffer> valuesList; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<java.nio.ByteBuffer> bitmapList; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TIMESTAMPS((short)1, "timestamps"),
    VALUES_LIST((short)2, "valuesList"),
    BITMAP_LIST((short)3, "bitmapList");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TIMESTAMPS
          return TIMESTAMPS;
        case 2: // VALUES_LIST
          return VALUES_LIST;
        case 3: // BITMAP_LIST
          return BITMAP_LIST;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TIMESTAMPS, new org.apache.thrift.meta_data.FieldMetaData("timestamps", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.VALUES_LIST, new org.apache.thrift.meta_data.FieldMetaData("valuesList", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING            , true))));
    tmpMap.put(_Fields.BITMAP_LIST, new org.apache.thrift.meta_data.FieldMetaData("bitmapList", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING            , true))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(QueryDataSet.class, metaDataMap);
  }

  public QueryDataSet() {
  }

  public QueryDataSet(
    java.nio.ByteBuffer timestamps,
    java.util.List<java.nio.ByteBuffer> valuesList,
    java.util.List<java.nio.ByteBuffer> bitmapList)
  {
    this();
    this.timestamps = org.apache.thrift.TBaseHelper.copyBinary(timestamps);
    this.valuesList = valuesList;
    this.bitmapList = bitmapList;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public QueryDataSet(QueryDataSet other) {
    if (other.isSetTimestamps()) {
      this.timestamps = org.apache.thrift.TBaseHelper.copyBinary(other.timestamps);
    }
    if (other.isSetValuesList()) {
      java.util.List<java.nio.ByteBuffer> __this__valuesList = new java.util.ArrayList<java.nio.ByteBuffer>(other.valuesList);
      this.valuesList = __this__valuesList;
    }
    if (other.isSetBitmapList()) {
      java.util.List<java.nio.ByteBuffer> __this__bitmapList = new java.util.ArrayList<java.nio.ByteBuffer>(other.bitmapList);
      this.bitmapList = __this__bitmapList;
    }
  }

  public QueryDataSet deepCopy() {
    return new QueryDataSet(this);
  }

  @Override
  public void clear() {
    this.timestamps = null;
    this.valuesList = null;
    this.bitmapList = null;
  }

  public byte[] getTimestamps() {
    setTimestamps(org.apache.thrift.TBaseHelper.rightSize(timestamps));
    return timestamps == null ? null : timestamps.array();
  }

  public java.nio.ByteBuffer bufferForTimestamps() {
    return org.apache.thrift.TBaseHelper.copyBinary(timestamps);
  }

  public QueryDataSet setTimestamps(byte[] timestamps) {
    this.timestamps = timestamps == null ? (java.nio.ByteBuffer)null   : java.nio.ByteBuffer.wrap(timestamps.clone());
    return this;
  }

  public QueryDataSet setTimestamps(@org.apache.thrift.annotation.Nullable java.nio.ByteBuffer timestamps) {
    this.timestamps = org.apache.thrift.TBaseHelper.copyBinary(timestamps);
    return this;
  }

  public void unsetTimestamps() {
    this.timestamps = null;
  }

  /** Returns true if field timestamps is set (has been assigned a value) and false otherwise */
  public boolean isSetTimestamps() {
    return this.timestamps != null;
  }

  public void setTimestampsIsSet(boolean value) {
    if (!value) {
      this.timestamps = null;
    }
  }

  public int getValuesListSize() {
    return (this.valuesList == null) ? 0 : this.valuesList.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.nio.ByteBuffer> getValuesListIterator() {
    return (this.valuesList == null) ? null : this.valuesList.iterator();
  }

  public void addToValuesList(java.nio.ByteBuffer elem) {
    if (this.valuesList == null) {
      this.valuesList = new java.util.ArrayList<java.nio.ByteBuffer>();
    }
    this.valuesList.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.nio.ByteBuffer> getValuesList() {
    return this.valuesList;
  }

  public QueryDataSet setValuesList(@org.apache.thrift.annotation.Nullable java.util.List<java.nio.ByteBuffer> valuesList) {
    this.valuesList = valuesList;
    return this;
  }

  public void unsetValuesList() {
    this.valuesList = null;
  }

  /** Returns true if field valuesList is set (has been assigned a value) and false otherwise */
  public boolean isSetValuesList() {
    return this.valuesList != null;
  }

  public void setValuesListIsSet(boolean value) {
    if (!value) {
      this.valuesList = null;
    }
  }

  public int getBitmapListSize() {
    return (this.bitmapList == null) ? 0 : this.bitmapList.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.nio.ByteBuffer> getBitmapListIterator() {
    return (this.bitmapList == null) ? null : this.bitmapList.iterator();
  }

  public void addToBitmapList(java.nio.ByteBuffer elem) {
    if (this.bitmapList == null) {
      this.bitmapList = new java.util.ArrayList<java.nio.ByteBuffer>();
    }
    this.bitmapList.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.nio.ByteBuffer> getBitmapList() {
    return this.bitmapList;
  }

  public QueryDataSet setBitmapList(@org.apache.thrift.annotation.Nullable java.util.List<java.nio.ByteBuffer> bitmapList) {
    this.bitmapList = bitmapList;
    return this;
  }

  public void unsetBitmapList() {
    this.bitmapList = null;
  }

  /** Returns true if field bitmapList is set (has been assigned a value) and false otherwise */
  public boolean isSetBitmapList() {
    return this.bitmapList != null;
  }

  public void setBitmapListIsSet(boolean value) {
    if (!value) {
      this.bitmapList = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TIMESTAMPS:
      if (value == null) {
        unsetTimestamps();
      } else {
        if (value instanceof byte[]) {
          setTimestamps((byte[])value);
        } else {
          setTimestamps((java.nio.ByteBuffer)value);
        }
      }
      break;

    case VALUES_LIST:
      if (value == null) {
        unsetValuesList();
      } else {
        setValuesList((java.util.List<java.nio.ByteBuffer>)value);
      }
      break;

    case BITMAP_LIST:
      if (value == null) {
        unsetBitmapList();
      } else {
        setBitmapList((java.util.List<java.nio.ByteBuffer>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TIMESTAMPS:
      return getTimestamps();

    case VALUES_LIST:
      return getValuesList();

    case BITMAP_LIST:
      return getBitmapList();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case TIMESTAMPS:
      return isSetTimestamps();
    case VALUES_LIST:
      return isSetValuesList();
    case BITMAP_LIST:
      return isSetBitmapList();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof QueryDataSet)
      return this.equals((QueryDataSet)that);
    return false;
  }

  public boolean equals(QueryDataSet that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_timestamps = true && this.isSetTimestamps();
    boolean that_present_timestamps = true && that.isSetTimestamps();
    if (this_present_timestamps || that_present_timestamps) {
      if (!(this_present_timestamps && that_present_timestamps))
        return false;
      if (!this.timestamps.equals(that.timestamps))
        return false;
    }

    boolean this_present_valuesList = true && this.isSetValuesList();
    boolean that_present_valuesList = true && that.isSetValuesList();
    if (this_present_valuesList || that_present_valuesList) {
      if (!(this_present_valuesList && that_present_valuesList))
        return false;
      if (!this.valuesList.equals(that.valuesList))
        return false;
    }

    boolean this_present_bitmapList = true && this.isSetBitmapList();
    boolean that_present_bitmapList = true && that.isSetBitmapList();
    if (this_present_bitmapList || that_present_bitmapList) {
      if (!(this_present_bitmapList && that_present_bitmapList))
        return false;
      if (!this.bitmapList.equals(that.bitmapList))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTimestamps()) ? 131071 : 524287);
    if (isSetTimestamps())
      hashCode = hashCode * 8191 + timestamps.hashCode();

    hashCode = hashCode * 8191 + ((isSetValuesList()) ? 131071 : 524287);
    if (isSetValuesList())
      hashCode = hashCode * 8191 + valuesList.hashCode();

    hashCode = hashCode * 8191 + ((isSetBitmapList()) ? 131071 : 524287);
    if (isSetBitmapList())
      hashCode = hashCode * 8191 + bitmapList.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(QueryDataSet other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetTimestamps()).compareTo(other.isSetTimestamps());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimestamps()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timestamps, other.timestamps);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetValuesList()).compareTo(other.isSetValuesList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValuesList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.valuesList, other.valuesList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetBitmapList()).compareTo(other.isSetBitmapList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBitmapList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bitmapList, other.bitmapList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("QueryDataSet(");
    boolean first = true;

    sb.append("timestamps:");
    if (this.timestamps == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.timestamps, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("valuesList:");
    if (this.valuesList == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.valuesList, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("bitmapList:");
    if (this.bitmapList == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.bitmapList, sb);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (timestamps == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'timestamps' was not present! Struct: " + toString());
    }
    if (valuesList == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'valuesList' was not present! Struct: " + toString());
    }
    if (bitmapList == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'bitmapList' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class QueryDataSetStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public QueryDataSetStandardScheme getScheme() {
      return new QueryDataSetStandardScheme();
    }
  }

  private static class QueryDataSetStandardScheme extends org.apache.thrift.scheme.StandardScheme<QueryDataSet> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, QueryDataSet struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TIMESTAMPS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.timestamps = iprot.readBinary();
              struct.setTimestampsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // VALUES_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list92 = iprot.readListBegin();
                struct.valuesList = new java.util.ArrayList<java.nio.ByteBuffer>(_list92.size);
                @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _elem93;
                for (int _i94 = 0; _i94 < _list92.size; ++_i94)
                {
                  _elem93 = iprot.readBinary();
                  struct.valuesList.add(_elem93);
                }
                iprot.readListEnd();
              }
              struct.setValuesListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // BITMAP_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list95 = iprot.readListBegin();
                struct.bitmapList = new java.util.ArrayList<java.nio.ByteBuffer>(_list95.size);
                @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _elem96;
                for (int _i97 = 0; _i97 < _list95.size; ++_i97)
                {
                  _elem96 = iprot.readBinary();
                  struct.bitmapList.add(_elem96);
                }
                iprot.readListEnd();
              }
              struct.setBitmapListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, QueryDataSet struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.timestamps != null) {
        oprot.writeFieldBegin(TIMESTAMPS_FIELD_DESC);
        oprot.writeBinary(struct.timestamps);
        oprot.writeFieldEnd();
      }
      if (struct.valuesList != null) {
        oprot.writeFieldBegin(VALUES_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.valuesList.size()));
          for (java.nio.ByteBuffer _iter98 : struct.valuesList)
          {
            oprot.writeBinary(_iter98);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.bitmapList != null) {
        oprot.writeFieldBegin(BITMAP_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.bitmapList.size()));
          for (java.nio.ByteBuffer _iter99 : struct.bitmapList)
          {
            oprot.writeBinary(_iter99);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class QueryDataSetTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public QueryDataSetTupleScheme getScheme() {
      return new QueryDataSetTupleScheme();
    }
  }

  private static class QueryDataSetTupleScheme extends org.apache.thrift.scheme.TupleScheme<QueryDataSet> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, QueryDataSet struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeBinary(struct.timestamps);
      {
        oprot.writeI32(struct.valuesList.size());
        for (java.nio.ByteBuffer _iter100 : struct.valuesList)
        {
          oprot.writeBinary(_iter100);
        }
      }
      {
        oprot.writeI32(struct.bitmapList.size());
        for (java.nio.ByteBuffer _iter101 : struct.bitmapList)
        {
          oprot.writeBinary(_iter101);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, QueryDataSet struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.timestamps = iprot.readBinary();
      struct.setTimestampsIsSet(true);
      {
        org.apache.thrift.protocol.TList _list102 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
        struct.valuesList = new java.util.ArrayList<java.nio.ByteBuffer>(_list102.size);
        @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _elem103;
        for (int _i104 = 0; _i104 < _list102.size; ++_i104)
        {
          _elem103 = iprot.readBinary();
          struct.valuesList.add(_elem103);
        }
      }
      struct.setValuesListIsSet(true);
      {
        org.apache.thrift.protocol.TList _list105 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
        struct.bitmapList = new java.util.ArrayList<java.nio.ByteBuffer>(_list105.size);
        @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _elem106;
        for (int _i107 = 0; _i107 < _list105.size; ++_i107)
        {
          _elem106 = iprot.readBinary();
          struct.bitmapList.add(_elem106);
        }
      }
      struct.setBitmapListIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

