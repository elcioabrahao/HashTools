package br.com.alfa11.hashtools.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    public static String getHashSHA256(String plainText) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] hashbytes = digest.digest(
                plainText.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashbytes);
    }

    public static String getHashSHA3256(String plainText) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        final byte[] hashbytes = digest.digest(
                plainText.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashbytes);
    }

    public static String getHashMD5(String plainText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bytesOfMessage = plainText.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] theMD5digest = md.digest(bytesOfMessage);
        return bytesToHex(theMD5digest);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
