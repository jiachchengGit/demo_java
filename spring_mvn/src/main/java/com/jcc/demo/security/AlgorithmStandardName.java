/*
 * @(#) SpringMVC AlgorithmStandardName.java 2014年4月10日
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.security;
/**
 * <p>Title: AlgorithmStandardName.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2014年4月10日 上午11:03:57</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public interface AlgorithmStandardName {
   public enum  MessageDigest{
       MD2("MD2"),
       MD5("MD5"),
       SHA_1("SHA-1"),
       SHA_256("SHA-256"),
       SHA_384("SHA-384"),
       SHA_512("SHA-512");
       
       private String type;
       /**
        * get type value
        * @return the type
        */
       public String getType() {
           return type;
       }
    
       private MessageDigest(String type){
           this.type = type;
       }
   }
   
   public enum KeyGenerator{
        AES("AES"),
        ARCFOUR("ARCFOUR"),
        Blowfish("Blowfish"),
        DES("DES"),
        DESede("DESede"),
        HmacMD5("HmacMD5"),
        HmacSHA1 ("HmacSHA1"),
        HmacSHA256 ("HmacSHA256 "),
        HmacSHA384("HmacSHA384"),
        HmacSHA512("HmacSHA512"),
        RC2("RC2");
        
        private String type;
        /**
         * get type value
         * @return the type
         */
        public String getType() {
            return type;
        }
     
        private KeyGenerator(String type){
            this.type = type;
        }
   }
   public enum SecretKeyFactory{
         AES("AES"),
         ARCFOUR("ARCFOUR"),
         DES("DES"),
         DESede("DESede"),
         PBKDF2WithHmacSHA1("PBKDF2WithHmacSHA1"),
       /*
        * Examples:
        * PBEWithMD5AndDES (PKCS5, v 1.5),
        * PBEWithHmacSHA1AndDESede (PKCS5, v 2.0), and
        */
         PBEWithAnd("PBEWith%sAnd%s");
         private String type;
         /**
          * get type value
          * @return the type
          */
         public String getType() {
             return type;
         }
      
         private SecretKeyFactory(String type){
             this.type = type;
         }
   }
}
