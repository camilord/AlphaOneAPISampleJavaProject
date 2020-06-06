package nz.alphaone.library.api.Util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * AlphaOneAPISampleProjectGradle
 * Copyright 2020
 * Generated in IntelliJ IDEA.
 * Developer: Camilo Lozano III
 * -> www.camilord.com
 * -> github.com/camilord
 * -> linkedin.com/in/camilord
 * Username: Camilo
 * Date: 6/06/2020
 * Time: 11:14 PM
 */
public class EncryptionUtil
{
    /**
     * MD5 hashing algoritm
     * @param text String
     * @return String
     */
    public static String md5(String text)
    {
        String hashtext = "";

        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(text.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            hashtext = bigInt.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while(hashtext.length() < 32 ){
                hashtext = "0" + hashtext;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashtext;
    }

    /**
     * SHA-1 hashing algorithm
     * @param text String
     * @return String
     */
    public static String sha1(String text)
    {
        String hashtext = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(text.getBytes(StandardCharsets.UTF_8));

            Formatter formatter = new Formatter();
            for (byte b : crypt.digest())
            {
                formatter.format("%02x", b);
            }
            hashtext = formatter.toString();
            formatter.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return hashtext;
    }
}
