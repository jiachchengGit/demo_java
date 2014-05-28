/*
 * @(#) SpringMVC DynamicProxyMain.java 2014年3月4日
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.proxy.dynamic;

import com.jcc.demo.proxy.Greet;
import com.jcc.demo.proxy.GreetImpl;

/**
 * <p>Title: DynamicProxyMain.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2014年3月4日 下午5:15:15</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class DynamicProxyMain {

    public static void main(String[] args) {
        //instant the obj to be proxy
       Greet proxy =(Greet) GreetDynamicProxy.newInstance(new GreetImpl());
        String sayHello = proxy.sayHello("DynamicName");
        System.out.println(sayHello);
        System.out.println();
        proxy.goodBye("NiMei");
    }
}
