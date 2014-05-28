package com.jcc.base.db.mybatis;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.logicalcobwebs.proxool.ProxoolDataSource;

/**
 * <p>Title: ProxoolDataSourceFactory.java</p>
 * <p>Description: 配置数据库的资源文件信息</p>
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2013-6-4 下午2:51:38</p>
 * @author liushuai
 * @version 1.0
 **/
public class ProxoolDataSourceFactory implements DataSourceFactory {
    private ProxoolDataSource dataSource;
 
    /**
     * 构造方法
     */
    public ProxoolDataSourceFactory() {
        this.dataSource = new ProxoolDataSource();
    }
 
    public DataSource getDataSource() {
        return this.dataSource;
    }
 
    /** 
     * (non-Javadoc)
     * @param properties  资源文件
     * @see org.apache.ibatis.datasource.DataSourceFactory#setProperties(java.util.Properties)
     */
    public void setProperties(Properties properties) {
    	try{
    		//设置驱动
    	    dataSource.setDriver("driver");//由其他类注入
	        //数据库连接地址
    	    dataSource.setDriverUrl("url");
	        //数据库用户名
	        dataSource.setUser("user");
	        //数据库密码
	        dataSource.setPassword("password");
	        //最小连接数
	        dataSource.setMinimumConnectionCount
	        (Integer.parseInt(properties.getProperty("minimumConnectionCount")));
	        //最大连接数
	        dataSource.setMaximumConnectionCount
	        (Integer.parseInt(properties.getProperty("maximumConnectionCount")));
	        //连接池中可用的连接数量.如果当前的连接池中的连接少于这个数值.新的连接将被建立
	        dataSource.setPrototypeCount(Integer.parseInt(properties.getProperty("prototype-count")));
	        //如果发现了空闲的数据库连接.house keeper 将会用这个语句来测试
	        dataSource.setHouseKeepingTestSql(properties.getProperty("house-keeping-test-sql"));
	        //如果housekeeper 检测到某个线程的活动时间大于这个数值.它将会杀掉这个线程.所以确认一下你的服务器的带宽.然后定一个合适的值.默认是5分钟. 
	        dataSource.setMaximumActiveTime(Long.valueOf(properties.getProperty("maximum-active-time")));
	        //如果为true，在每个连接被测试前都会服务这个连接，如果一个连接失败，那么将被丢弃，另一个连接将会被处理，如果所有连接都失败，一个新的连接将会被建立。
	        dataSource.setTestBeforeUse(true);
	        //如果为true，在每个连接被测试后都会服务这个连接，使其回到连接池中，如果连接失败，那么将被废弃。 
	        dataSource.setTestAfterUse(true);
    	}
    	catch(Exception e){
    	}
        
    }
    
    
}