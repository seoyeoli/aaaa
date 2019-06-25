package com.my.company.common.util;

import java.security.MessageDigest;
 
public class SHA256Password {
 
    public String LockPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
 
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            // 출력
            //System.out.println("\n\n입력pw인코딩:"+hexString.toString()+"\n\n");
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } 
 
    }
}


