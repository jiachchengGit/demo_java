/*
 * @(#) SpringMVC TestApsectMain.java Jan 6, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.aspect.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jcc.demo.aspect.pojo.UserBean;

/**
 * <p>Title: TestApsectMain.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 6, 2014 8:49:20 AM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class TestApsectMain {
    /**
     * @author chenjiacheng
     * @creaetime Jan 6, 2014 8:49:20 AM
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("spring-aspect-context.xml");
        UserBean bean = (UserBean) cxt.getBean("userBean");
        bean.sayHello();
    }
}
