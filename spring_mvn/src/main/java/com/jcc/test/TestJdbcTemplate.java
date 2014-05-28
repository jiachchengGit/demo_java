/*
 * @(#) SpringMVC TestJdbcTemplate.java 2014年2月24日
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * <p>Title: TestJdbcTemplate.java</p>
 * <p>Description: JdbcTemplate操作测试类</p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2014年2月24日 下午1:44:20</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class TestJdbcTemplate {
    /*
     * 模版对象
     */
    private JdbcTemplate jt;
    /*
     *线程池对象 
     */
    private ExecutorService executor;
    /*
     * 查询结果列
     */
    List<QueryObj> listObj;
    
    /**
     * @param dbUserName 数据库用户名
     * @param dbPassword 数据密码
     * @param dbUrl 数据库连接IP："jdbc:oracle:thin:@" + dbIp + ":1521:powerlist"
     * @param driveClassName 驱动类：oracle.jdbc.driver.OracleDriver
     */
    public TestJdbcTemplate(String dbUserName,String dbPassword,String dbUrl,String driveClassName){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(dbUrl);
        ds.setUsername(dbUserName);
        ds.setPassword(dbPassword);
        ds.setDriverClassName(driveClassName);
        jt = new JdbcTemplate(ds);
        executor = Executors.newFixedThreadPool(20);
    }
    
    public void doQuery(){
        listObj = jt.query("Sql", new RowMapper<QueryObj>(){
            @Override
            public QueryObj mapRow(ResultSet rs, int rowNum) throws SQLException {
                QueryObj obj = new QueryObj();
                obj.id = rs.getInt(1);
                obj.name = rs.getString(2);
                return obj;
            }
        });
        
        //使用线程池异步并发执行业务
        for(int i = 0;i<listObj.size();i++){
            executor.submit(new Runnable(){
                @Override
                public void run() {
                   //执行其他操作
                    
                }});
        }
    }
}

class QueryObj{
    int id;
    String name;
}
