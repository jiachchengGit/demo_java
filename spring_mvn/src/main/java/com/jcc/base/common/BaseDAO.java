/*
 * @(#) SpringMVC BaseDAOC.java Jan 3, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.base.common;
/**
 * <p>Title: BaseDAOC.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 3, 2014 2:32:45 PM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public interface BaseDAO<T extends BaseModel> {
    public void insert(T o);
}
