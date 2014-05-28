/*
 * @(#) SpringMVC BaseService.java Jan 3, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.base.common;

/**
 * <p>Title: BaseService.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 3, 2014 2:37:14 PM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public interface BaseService<T extends BaseModel> {
    public void setBaseDAO(BaseDAO<T> baseDAO);
    public void insert(T o);
}
