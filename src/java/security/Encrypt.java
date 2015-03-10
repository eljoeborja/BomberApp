package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {

    private static final String SHA512 = "SHA-512";

    private static String toHexadecimal(byte[] digest){
        String hash = "";
        for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }
        return hash;
    }

    @SuppressWarnings("CallToThreadDumpStack")
    public static String getStringMessageDigest(String message){
        try {
            byte[] digest = null;
            byte[] buffer = message.getBytes();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(SHA512);
                messageDigest.reset();
                messageDigest.update(buffer);
                digest = messageDigest.digest();
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
            return toHexadecimal(digest);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return "";
    }     
}