/*
 * @(#) SpringMVC SymSecurityUtil.java 2014年4月10日
 * 
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.security;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * <p>Title: SymSecurityUtil.java</p>
 * <p>Description: 对称加密算法工具 </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2014年4月10日 下午1:52:57</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class SymSecurityUtil extends SecurityUtil {
    
    /**
     * 加密算法
     */
    private static String ALGORITHM = AlgorithmStandardName.SecretKeyFactory.DES.getType();
    
    private SymSecurityUtil(){}
    private static SymSecurityUtil sUtil = null;
    /**
     * 获取实例化对象
     * @author chenjiacheng
     * @creaetime 2014年4月10日 下午2:12:35
     * @param algorithm
     * @return
     */
    public static SymSecurityUtil getInstance(AlgorithmStandardName.SecretKeyFactory algorithm){
        if(algorithm != null ){
            ALGORITHM = algorithm.getType();
        }
        if(sUtil == null){
            sUtil= new SymSecurityUtil();
        }
        return sUtil;
    }
    /**
     * 转换密钥
     * @author chenjiacheng
     * @creaetime 2014年4月10日 下午1:53:27
     * @param key
     * @return
     * @throws Exception
     */
    private  Key toKey(byte[] key) throws Exception {
        if(ALGORITHM.equals(AlgorithmStandardName.SecretKeyFactory.DES.getType())){
            DESKeySpec dks = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            SecretKey secretKey = keyFactory.generateSecret(dks);
            return secretKey;
        }else{
            // 当使用其他对称加密算法时，如AES、Blowfish等算法时，用下述代码替换上述三行代码
             SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
             return secretKey;
        }
    }

    /**
     * 解密
     * @author chenjiacheng
     * @creaetime 2014年4月10日 下午1:55:58
     * @param data 解密数据
     * @param key 由初始化密匙方法产生
     * @return
     * @throws Exception
     */
    public  byte[] decrypt(byte[] data, String key) throws Exception {
        Key k = toKey(decryptBASE64(key));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);
        return cipher.doFinal(data);
    }

    /**
     * 加密
     * @author chenjiacheng
     * @creaetime 2014年4月10日 下午1:56:40
     * @param data 要加密的数据
     * @param key 由初始化密匙方法产生
     * @return
     * @throws Exception
     */
    public  byte[] encrypt(byte[] data, String key) throws Exception {
        Key k = toKey(decryptBASE64(key));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);
        return cipher.doFinal(data);
    }
    
    /**
     * 经过BASE64编码产生加密Key的字符串
     * @author chenjiacheng
     * @creaetime 2014年4月10日 下午2:14:02
     * @param seed
     * @return
     * @throws Exception
     */
    public  String initKey(String seed) throws Exception {
        SecureRandom secureRandom = null;
        if ( seed != null ) {
            secureRandom = new SecureRandom(decryptBASE64(seed));
        }
        else {
            secureRandom = new SecureRandom();
        }
        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
        kg.init(secureRandom);
        SecretKey secretKey = kg.generateKey();
        return encryptBASE64(secretKey.getEncoded());
    }
    
    public static void main(String[] args) throws Exception{
        String inputStr = "DES";  
        AlgorithmStandardName.SecretKeyFactory algorythm = AlgorithmStandardName.SecretKeyFactory.AES;
        String seed = "chen";
        String key = SymSecurityUtil.getInstance(algorythm).initKey(seed);  
        System.out.println("原文:\t" + inputStr);  
        System.out.println("密钥:\t" + key);  
        byte[] inputData = inputStr.getBytes();  
        inputData =SymSecurityUtil.getInstance(algorythm).encrypt(inputData, key);  
        System.out.println("加密后:\t" + SymSecurityUtil.getInstance(algorythm).encryptBASE64(inputData));  
        byte[] outputData = SymSecurityUtil.getInstance(algorythm).decrypt(inputData, key);  
        String outputStr = new String(outputData);  
        System.out.println("解密后:\t" + outputStr);  
    }
}
