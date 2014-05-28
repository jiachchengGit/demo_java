/**
 * @(#) SpringMVC UserAspect.java Jan 6, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.aspect.pointcut;

/**
 * <p>Title: UserAspect.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 6, 2014 8:45:08 AM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class UserAspect {
    public void beforeAspect(){
        System.out.println("Before say Hello.....");
    }
    
}
