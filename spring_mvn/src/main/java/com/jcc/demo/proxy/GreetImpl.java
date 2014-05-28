/**
 * 
 */
/*
 * @(#) SpringMVC GreetImpl.java 2014年3月4日
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.proxy;


/**
 * <p>Title: GreetImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2014年3月4日 下午4:51:21</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class GreetImpl implements Greet {

//    private String name;
//    
//    public GreetImpl(String name){
//        this.name = name;
//    }
    /** (non-Javadoc)
     * @see com.jcc.demo.proxy.Greet#sayHello(java.lang.String)
     */
    @Override
    public String sayHello(String name) {
        System.out.println("Hello,"+name+".....");
        return "Hello";
    }

    /** (non-Javadoc)
     * @see com.jcc.demo.proxy.Greet#goodBye(java.lang.String)
     */
    @Override
    public String goodBye(String name) {
        System.out.println("GoodBye,"+name+".....");
        return "Good";
    }

}
