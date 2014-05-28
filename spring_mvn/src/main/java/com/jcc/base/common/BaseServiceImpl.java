/*
 * @(#) SpringMVC BaseServiceImpl.java Jan 3, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.base.common;

/**
 * <p>Title: BaseServiceImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 3, 2014 2:39:01 PM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {
    private BaseDAO<T> baseDAO = null;
    public BaseDAO<T> getBaseDAO() {
        return baseDAO;
    }
    
    @Override
    public void setBaseDAO(BaseDAO<T> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    public void insert(T o) {
        this.baseDAO.insert(o);
    }
}
