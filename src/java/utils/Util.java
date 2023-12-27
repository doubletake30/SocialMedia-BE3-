/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import models.dm.User;

/**
 *
 * @author ADMIN
 */
public class Util {

    /*
     * encryptPassword is used for encrypting the password before saving it to the database.
     * encryptPassword is used for encrypting the ID before assigning it to a cookie's value.
     */
    public static String encryptPassword(String password) {
        if (password == null) {
            // Handle the case where the password is null
            return null;
        }

        try {
            // Use the SHA-256 hashing algorithm
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = messageDigest.digest(password.getBytes());

            // Convert the byte array to a hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // Return the hashed password in hexadecimal format
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Handle the exception if the algorithm is not supported
            return null;
        }
    }


}