/**
 * 
 */
/*
 * @(#) SpringMVC MyAnnotation.java Jan 10, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Title: MyAnnotation.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 10, 2014 11:01:35 AM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
@Target(ElementType.METHOD) //注解作用对象为方法
@Retention(RetentionPolicy.RUNTIME) //注解在运行时生效
@Inherited //被注解的方法可以在子类中继承
public @interface MyAnnotation {
    //名称
    public NameEnum name() default NameEnum.CHENJIACHENG;
    //地址
    public AddressEnum address() default AddressEnum.CHINA_CHENGDU;
}
