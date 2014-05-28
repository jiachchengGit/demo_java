/*
 * @(#) dpm SqlMapTest.java 2011-01-21
 * 
 * Copyright 2011 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * <p>
 * Title: SqlMapTest.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright:Copyright(c)2011
 * </p>
 * <p>
 * Company: 成都四方
 * </p>
 * <p>
 * CreateTime:2011-01-21 10:08:42
 * </p>
 * 
 * @author wanggang
 * @version 1.0
 */
public class SqlMapGenerator {
    public static void main(String[] args) throws IOException,
            XMLParserException, InvalidConfigurationException,
            SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile =
                          new File(ClassLoader.getSystemClassLoader()
                                  .getResource("generatorConfig.xml")
                                  .getFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        System.out.println(configFile.getPath());
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback =
                                        new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator =
                                            new MyBatisGenerator(config,
                                                    callback, warnings);
        myBatisGenerator.generate(null);
    }
}
