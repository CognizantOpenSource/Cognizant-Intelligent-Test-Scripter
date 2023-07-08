package com.cognizant.cognizantits.util.encryption;

import com.cognizant.cognizantits.engine.constants.FilePath;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.apache.commons.io.FileUtils;

public class Encryption {

    static Encryption encrypt;

    IvParameterSpec ivspec;

    SecretKeyFactory factory;

    KeySpec spec;

    SecretKey tmp;

    SecretKeySpec secretKey;

    public static Encryption getInstance() {
        if (encrypt == null) {
            encrypt = new Encryption();
        }
        return encrypt;
    }

    private Encryption() {
        init();
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
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String encrypt(String strToEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (InvalidKeyException | InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String decrypt(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException
                | BadPaddingException | IllegalBlockSizeException | InvalidKeyException
                | NoSuchPaddingException e) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    private String initKey() {
        try {
            File encFile = new File(FilePath.getEncFile());
            if (encFile.exists()) {
                return FileUtils.readFileToString(encFile, "UTF-8");
            } else {
                Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, "Key File not exist");
            }
        } catch (IOException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
