/*
 * @(#) uportal InitAction.java Jan 31, 2011
 * 
 * Copyright 2011 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

/**
 * <p>Title: InitAction.java</p>
 * <p>Description: 启动类</p>
 * <p>Copyright:Copyright(c)2013</p>  
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2013-6-4 下午2:57:02</p>
 * @author liushuai
 * @version 1.0
 **/
public class InitAction extends HttpServlet {
    Logger logger = Logger.getLogger(InitAction.class);
    // tomcat用户无法访问Xserver，包括Xserver没有启动或者没有权限访问。
    static {
        System.setProperty("java.awt.headless", "true");
    }
    
    private static final long serialVersionUID = 1L;
    public static HashMap<Integer, Integer> pageOpenstauts = null;
    
    //mongoDB相关参数
    public static String mongodbIp = null;
    /** 存放必要的配置信息，如数据库连接信息 */
    private static Properties pro = null;
    
    
    @Override
    public void init(ServletConfig config) {
    }

    /**
     * 文件上传处理类
     * @author liujunliang
     * @creaetime 2013-6-4 下午2:57:19
     * @throws IOException
     */
    public void readConfig() throws IOException {
        pro = new Properties();
        InputStream is = (this.getClass().getClassLoader().getResourceAsStream("config.properties"));
        pro.load(is);
        mongodbIp = pro.getProperty("MONGODB_IP").trim();
        is.close();
    }
}
