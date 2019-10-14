/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cognizant.cognizantits.extension.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.eclipse.jetty.util.resource.Resource;

public class Encrypt {
    
    static Encrypt instance;
    
    IvParameterSpec ivspec;

    SecretKeyFactory factory;

    KeySpec spec;

    SecretKey tmp;

    SecretKeySpec secretKey;
    
    public static Encrypt getInstance() {
        if (instance == null) {
            instance = new Encrypt();
        }
        return instance;
    }
    
    private Encrypt() {
        init();
    }
    
    public String decrypt(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException
                | BadPaddingException | IllegalBlockSizeException | InvalidKeyException
                | NoSuchPaddingException e) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    private void init() {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            ivspec = new IvParameterSpec(iv);
            String passKey = initKey();
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            spec = new PBEKeySpec(passKey.toCharArray(), passKey.getBytes(), 65536, 256);
            tmp = factory.generateSecret(spec);
            secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String initKey() {
        try {
            Resource res = Resource.newResource(ClassLoader.getSystemResource(".enc"));
            InputStream inputStream = res.getInputStream();
            return new String(inputStream.readAllBytes());
        } catch (IOException e) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
