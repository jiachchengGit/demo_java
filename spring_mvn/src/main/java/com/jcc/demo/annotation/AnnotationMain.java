/*
 * @(#) SpringMVC AnnotationMain.java Jan 10, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.annotation;

import java.lang.reflect.Method;

/**
 * <p>Title: AnnotationMain.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 10, 2014 11:12:46 AM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class AnnotationMain {

    /**
     * @author chenjiacheng
     * @creaetime Jan 10, 2014 11:12:46 AM
     * @param args
     */
    public static void main(String[] args) {
        Class<?> c = null;
        c = Person.class;
        Method[] methods = c.getMethods();
        for(Method m :methods){
            if(m.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
                AddressEnum address = annotation.address();
                NameEnum name = annotation.name();
                System.out.println("Person address:"+address);
                System.out.println("Person name:"+name);
            }
        }
        
        Class<?> china = null;
        china = ChinaPerson.class;
        Method[] m2 = china.getMethods();
        for(Method m :m2){
            if(m.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
                AddressEnum address = annotation.address();
                NameEnum name = annotation.name();
                System.out.println("ChinaPerson address:"+address);
                System.out.println("ChinaPerson name:"+name);
            }
        }
    }
}
