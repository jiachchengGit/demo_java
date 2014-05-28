/*
 * @(#) dpm DBUtil.java Jan 20, 2011
 * 
 * Copyright 2011 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.base.db.mybatis;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * <p>Title: DBUtil.java</p>
 * <p>Description: 数据库相关工具类，主要用于获取SqlSession</p>
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2013-6-4 下午2:43:57</p>
 * @author liushuai
 * @version 1.0
 **/
public class DBUtil {

    /** SqlSession工厂类 */
    private static SqlSessionFactory factory = null;

    /**
     * 加载数据源相关信息，
     * 初始化工厂
     */
    static {
        try {
            Reader reader = Resources.getResourceAsReader("Configuration.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author liushuai
     * @creaetime 2013-6-4 下午2:44:16
     * @return 数据源工厂
     */
    public static synchronized SqlSessionFactory getFactory() {
        return factory;
    }

    /**
     * 获取一个普通SqlSession，
     * 该SqlSession不会自动提交当前事务
     * @author liushuai
     * @creaetime 2013-6-4 下午2:48:27
     * @return
     */
    public static synchronized SqlSession getSession() {
        SqlSession session = null;
        session = factory.openSession();
        return session;
    }
    

    /**
     * 获取指定提交处理类型的SqlSession
     * @author liushuai
     * @creaetime 2013-6-4 下午2:49:13
     * @param type 对预编译语句的使用方法，为MyBatis提供的枚举类型
     * @return
     */
    public static synchronized  SqlSession getSession(ExecutorType type) {
        SqlSession session = null;
        session = factory.openSession(type);
        return session;
    }
}
