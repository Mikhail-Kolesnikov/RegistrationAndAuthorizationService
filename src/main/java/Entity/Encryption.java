package Entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public enum Encryption {
    SHA1;


    public String encrypt(String password) {


            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                byte[] hash = messageDigest.digest(password.getBytes());
                StringBuilder stringBuilder=new StringBuilder();
                for (byte b : hash) {
                    stringBuilder.append(String.format("%02x",b));

                }
                return stringBuilder.toString();
            }catch (NoSuchAlgorithmException e){
                throw new RuntimeException(e);
            }
        }

    }


