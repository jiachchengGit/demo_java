/*
 * @(#) SpringMVC UserBean.java Jan 6, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.aspect.pojo;

import com.jcc.demo.aspect.service.UserService;

/**
 * <p>Title: UserBean.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 6, 2014 8:42:41 AM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class UserBean  implements UserService{
    
    private String userName="chenjiacheng";
    private String address="China,Guangxi";
    private int age = 23;
    /**
     * get userName value
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    /**
     * set userName value
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * get address value
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * set address value
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * get age value
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * set age value
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * @author chenjiacheng
     * @creaetime Jan 6, 2014 8:44:32 AM
     */
    @Override
    public void sayHello(){
        System.out.println("Hello,"+userName);
    }
}
