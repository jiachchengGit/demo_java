/*
 * @(#) SpringMVC Persion.java Jan 10, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.annotation;
/**
 * <p>Title: Persion.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 10, 2014 11:10:15 AM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class Person {
    @MyAnnotation(name=NameEnum.LIXIAOLING,address=AddressEnum.CHINA_GUANGXI)
   public void getPersionInfo(){
       System.out.println("Person.getPersionInfo()--------");
   }
}
