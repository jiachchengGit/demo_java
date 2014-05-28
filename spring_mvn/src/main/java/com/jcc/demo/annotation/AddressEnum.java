/**
 * 
 */
/*
 * @(#) SpringMVC AddressEnum.java Jan 10, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.annotation;
/**
 * <p>Title: AddressEnum.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 10, 2014 11:02:43 AM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public enum AddressEnum {
    CHINA_GUANGXI("中国-广西"),
    CHINA_CHENGDU("中国-成都"),
    AMERECAN_JINSHAN("美国-旧金山");
    
    private String type;
    /**
     * get type value
     * @return the type
     */
    public String getType() {
        return type;
    }

    private AddressEnum(String type){
        this.type = type;
    }

}
