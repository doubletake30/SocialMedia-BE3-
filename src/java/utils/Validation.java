/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import models.dao.UserDAO;

/**
 *
 * @author ADMIN
 */
public class Validation {

    public static boolean checkNameCountry(String inp) {

        if (inp.isEmpty()) {
            System.out.println("This can not be empty!!!");
            return false;
        }
        if (inp.matches("^.*[0-9!@#$%^&*(){}_+-=*/.<>?|].*")) {
            System.out.println("This can only contain characters");
            return false;
        }
        return true;
    }

    public static boolean checkPassword(String inp) {

        if (inp.isEmpty()) {
            System.out.println("Password must not be empty");
            return false;
        }
        if (!checkSpace(inp)) {
            System.out.println("Password must be no spaces");
            return false;
        }
        if (inp.length() < 6) {
            System.out.println("Password must be at least six characters");
            return false;
        }
        return true;

    }

    public static boolean checkSpace(String inp) {

        for (int i = 0; i < inp.length(); i++) {
            if (Character.isWhitespace(inp.charAt(i))) {
                return false;
            }
        }
        return true;

    }

    public static boolean checkPhone(String inp) {

        if (!checkSpace(inp)) {
            System.out.println("Phone does not contain white space");
            return false;
        }

        if (inp.isEmpty()) {
            System.out.println("Phone can not be empty!!!");
            return false;
        }

        if (!inp.matches("^[0-9]+$")) {
            System.out.println("Phone numbers can only contain digits");
            return false;
        }

        if (!inp.matches("^0[0-9]{9}$")) {
            System.out.println("Invalid phone number format. It should start with 0 and followed by 9 digits");
            return false;
        }

        if (inp.length() != 10) {
            System.out.println("Phone must be have 10 characters");
            return false;
        }
        if (!UserDAO.getInstance().checkDuplicatePhone(inp)) {
            return false;
        }
        
        return true;

    }
    
    public static boolean checkEmail(String inp) {

        if (!checkSpace(inp)) {
            System.out.println("Email does not contain white space");
            return false;
        }

        if (inp.isEmpty()) {
            System.out.println("Email can not be empty!!!");
            return false;
        }

        if (!inp.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("Invalid email format");
            return false;
        }

        if (!UserDAO.getInstance().checkDuplicateEmail(inp)) {
            System.out.println("Email is already in use");
            return false;
        }

        return true;
    }

}
