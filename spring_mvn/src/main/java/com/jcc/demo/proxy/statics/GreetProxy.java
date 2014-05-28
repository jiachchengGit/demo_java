/*
 * @(#) SpringMVC GreetProxy.java 2014年3月4日
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.proxy.statics;

import com.jcc.demo.proxy.Greet;

/**
 * <p>Title: GreetProxy.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2014年3月4日 下午4:53:06</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class GreetProxy implements Greet {
    private Greet greet;
    public GreetProxy(Greet greet){
        this.greet = greet;
    }
    
    @Override
    public String sayHello(String name) {
        System.out.println("Proxy before........");
        String sayHello = greet.sayHello(name);
        System.out.println("Proxy after........");
        return sayHello;
    }

    @Override
    public String goodBye(String name) {
        System.out.println("Proxy before........");
        String goodBye = greet.goodBye(name);
        System.out.println("Proxy after........");
        return goodBye;
    }
}
