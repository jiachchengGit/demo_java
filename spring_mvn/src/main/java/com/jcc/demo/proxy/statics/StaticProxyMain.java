/*
 * @(#) SpringMVC StaticProxyMain.java 2014年3月4日
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.proxy.statics;

import com.jcc.demo.proxy.GreetImpl;

/**
 * <p>Title: StaticProxyMain.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2014年3月4日 下午4:55:16</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class StaticProxyMain {

    public static void main(String[] args) {
      GreetProxy proxy = new GreetProxy(new GreetImpl());
      proxy.sayHello("CheckJJJ");
    }
}
