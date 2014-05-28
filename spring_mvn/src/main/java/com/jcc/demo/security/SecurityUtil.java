/*
 * @(#) SpringMVC SecurityUtil.java 2014年4月10日
 * 
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.security;

import java.security.MessageDigest;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <p>Title: SecurityUtil.java</p>
 * <p>Description: BASE64、MD5、SHA等单项摘要算法</p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2014年4月10日 上午10:54:56</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class SecurityUtil {
    /**
     * SHA256加密
     * @author chenjiacheng
     * @creaetime 2014年4月10日 上午11:07:26
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptSHA256(byte[] data,AlgorithmStandardName.MessageDigest md) throws Exception {
        MessageDigest sha = MessageDigest.getInstance(md.getType());
        sha.update(data);
        return sha.digest();
    }

    /**
     * MD5加密
     * @author chenjiacheng
     * @creaetime 2014年4月10日 上午11:08:12
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data,AlgorithmStandardName.MessageDigest md) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance(md.getType());
        md5.update(data);
        return md5.digest();
    }

    /**
     * Base64解码
     * @author chenjiacheng
     * @creaetime 2014年4月10日 上午11:09:02
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * Base64编码
     * @author chenjiacheng
     * @creaetime 2014年4月10日 上午11:09:05
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    /**
     * 初始化HMAC密钥
     * @return
     * @throws Exception
     */
    public static String initMacKey(AlgorithmStandardName.KeyGenerator key) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(key.getType());
        SecretKey secretKey = keyGenerator.generateKey();
        return encryptBASE64(secretKey.getEncoded());
    }

    /**
     * HMAC加密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptHMAC(byte[] data, String key,AlgorithmStandardName.KeyGenerator kg) throws Exception {
        SecretKey secretKey = new SecretKeySpec(decryptBASE64(key),kg.getType());
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        return mac.doFinal(data);
    }
}
