/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStoneWall.Cryptography;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.util.encoders.Hex;
import DataStoneWall.Utility.FileUtility;
import DataStoneWall.Utility.Message;

public class AppCipher {

    private SecretKey sk;
    private KeyGenerator kg;
    private byte[] key;
    AESBouncyCastle aes = new AESBouncyCastle();

    public AppCipher() {
        try {
            File file = new File("./secretkey.key");
            if (file.exists()) {
                key = FileUtility.readBytesFromFile(file);
            } else {
                try {
                    kg = KeyGenerator.getInstance("AES");
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(AppCipher.class.getName()).log(Level.SEVERE, null, ex);
                }
                kg.init(256);
                sk = kg.generateKey();
                FileUtility.writeBytesToFile(new File("./secretkey.key"), sk.getEncoded());
                key = sk.getEncoded();
            }
            aes.setPadding(new PKCS7Padding());
            aes.setKey(key);
        } catch (Exception ex) {
            Message.showMessage("Error in secret key \n " + ex.getMessage(), "error");
        }
    }
    public String decrypt(String data) {
        try {
            byte[] base63decoder = Base64.getDecoder().decode(data);
            byte[] retr = aes.decrypt(base63decoder);
            return new String(retr).trim();
        } catch (DataLengthException ex) {
            Logger.getLogger(AppCipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidCipherTextException ex) {
            Logger.getLogger(AppCipher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public String encrypt(String data) {
        try {
            byte[] ba;
            ba = data.getBytes("UTF-8");
            byte[] encr = aes.encrypt(ba);
            String encoded = Base64.getEncoder().encodeToString(encr);
            return encoded;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AppCipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataLengthException ex) {
            Logger.getLogger(AppCipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidCipherTextException ex) {
            Logger.getLogger(AppCipher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
