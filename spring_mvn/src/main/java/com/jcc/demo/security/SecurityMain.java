/*
 * @(#) SpringMVC SecurityMain.java 2014年4月10日
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.security;
/**
 * <p>Title: SecurityMain.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2014年4月10日 上午11:10:28</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class SecurityMain {

    public static void main(String[] args) throws Exception {
//       String str = "chenjiacheng";
//       byte[] encryptMD5 = SecurityUtil.encryptMD5(str.getBytes());
//       System.out.println("MD5 = "+new String(encryptMD5,"UTF-8"));
//       //-------------
//       String encryptBASE64 = SecurityUtil.encryptBASE64(encryptMD5);
//       System.out.println("MD5+BASE64 = "+encryptBASE64);
//       //-------------
//       byte[] encryptSHA256 = SecurityUtil.encryptSHA256(str.getBytes());
//        String encryptBASE642 = SecurityUtil.encryptBASE64(encryptSHA256);
//       System.out.println("SHA256+BASE64 = "+encryptBASE642);
//       //--------------
//       String initMacKey = SecurityUtil.initMacKey();
//       byte[] encryptHMAC = SecurityUtil.encryptHMAC(str.getBytes(), initMacKey);
//       String encryptBASE643 = SecurityUtil.encryptBASE64(encryptHMAC);
//       System.out.println("HMAC+BASE64 = "+encryptBASE643);
        String type = AlgorithmStandardName.MessageDigest.SHA_1.getType();
        System.out.println(type);
    }

}
