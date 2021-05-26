/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package cn.edu.tsinghua.iginx.core.context;

import cn.edu.tsinghua.iginx.thrift.ValueFilterQueryReq;
import cn.edu.tsinghua.iginx.utils.BooleanExpression;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ValueFilterQueryContext extends RequestContext {

	private ValueFilterQueryReq req;
	private BooleanExpression booleanExpression;

	public ValueFilterQueryContext(ValueFilterQueryReq req) {
		super(req.sessionId, ContextType.ValueFilterQuery);
		this.booleanExpression = new BooleanExpression(req.booleanExpression);
		this.req = req;
	}

	public ValueFilterQueryReq getReq() {
		return req;
	}

    public BooleanExpression getBooleanExpression()
    {
        return booleanExpression;
    }

    public void setBooleanExpression(BooleanExpression booleanExpression)
    {
        this.booleanExpression = booleanExpression;
    }

    public void setReq(ValueFilterQueryReq req)
    {
        this.req = req;
    }
}
