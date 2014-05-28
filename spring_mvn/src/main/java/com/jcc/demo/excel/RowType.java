/**
 * 
 */
/*
 * @(#) SpringMVC RowType.java Jan 10, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Title: RowType.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 10, 2014 2:23:12 PM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
@Target(value=ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RowType {
   //列序号
   public int index() default 0;
   //列名
   public String rowName() default "SystemColunm";
}
