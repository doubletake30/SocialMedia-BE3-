/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.dao;

import utils.JDBCUtil;
import models.dm.User;
import utils.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class UserDAO implements I_DAO<User> {

    public String login(String email, String password) {
        String result = "";
        try ( Connection con = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM User WHERE Email = ? AND Password = ?";
            try ( PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, email);
                pst.setString(2, Util.encryptPassword(password));

                try ( ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        result = rs.getString("UserID");
                    }
                }
            }
        } catch (SQLException e) {
            result = "";
            e.printStackTrace();
        }
        return result;
    }


    public static UserDAO getInstance() {
        return new UserDAO();
    }

    @Override
    public int insert(User user) {
        if (!checkDuplicateEmail(user.getEmail())) {
            return 0;
        }

        int result = 0;

        try ( Connection con = JDBCUtil.getConnection()) {
            String sql = "INSERT INTO User (FirstName, LastName, Email, Password, DateOfBirth, Bio, ProfilePicture, Gender, Country, Phone) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try ( PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, user.getFirstName());
                pst.setString(2, user.getLastName());
                pst.setString(3, user.getEmail());
                pst.setString(4, Util.encryptPassword(user.getPassword()));
                pst.setDate(5, new java.sql.Date(user.getDateOfBirth().getTime()));
                pst.setString(6, user.getBio());
                pst.setString(7, user.getProfilePicture());
                pst.setString(8, user.getGender());
                pst.setString(9, user.getCountry());
                pst.setString(10, user.getPhone());

                result = pst.executeUpdate();

                System.out.println("Sign up successful!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int update(User user) {
        // Implement update logic if needed
        return 0;
    }

    public int updateProfile(User user, boolean upPassword) {
        int result = 0;
        try ( Connection con = JDBCUtil.getConnection()) {
            String sql = "UPDATE User "
                    + "SET FirstName = ?, LastName = ?, DateOfBirth = ?, Gender = ?, Country = ?, Phone = ?, Email = ?, Password = ?, ProfilePicture = ? "
                    + "WHERE UserID = ?";

            try ( PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, user.getFirstName());
                pst.setString(2, user.getLastName());
                pst.setDate(3, (java.sql.Date) user.getDateOfBirth());
                pst.setString(4, user.getGender());
                pst.setString(5, user.getCountry());
                pst.setString(6, user.getPhone());
                pst.setString(7, user.getEmail());
                pst.setString(8, upPassword ? Util.encryptPassword(user.getPassword()) : user.getPassword());
                pst.setString(9, user.getProfilePicture());
                pst.setString(10, user.getUserID());

                result = pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(User t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> res = new ArrayList<>();
        try ( Connection con = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM User";

            try ( PreparedStatement pst = con.prepareStatement(sql);  ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("UserId");
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    Date dob = rs.getDate("DateOfBirth");
                    String sex = rs.getString("Gender");
                    String country = rs.getString("Country");
                    String phone = rs.getString("Phone");
                    String email = rs.getString("Email");
                    String password = rs.getString("Password");
                    String avatar = rs.getString("ProfilePicture");

                    User user = new User(id, firstName, lastName, dob, sex, country, phone, email, password, avatar);
                    res.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public User selectById(String id) {
        User result = null;
        try ( Connection con = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM User WHERE UserID = ?";

            try ( PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, id);

                try ( ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String userId = rs.getString("UserId");
                        String firstName = rs.getString("FirstName");
                        String lastName = rs.getString("LastName");
                        Date dob = rs.getDate("DateOfBirth");
                        String sex = rs.getString("Gender");
                        String country = rs.getString("Country");
                        String phone = rs.getString("Phone");
                        String email = rs.getString("Email");
                        String password = rs.getString("Password");
                        String avatar = rs.getString("ProfilePicture");

                        result = new User(userId, firstName, lastName, dob, sex, country, phone, email, password, avatar);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
        ArrayList<User> res = new ArrayList<>();
        try ( Connection con = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM User "
                    + "WHERE (FirstName LIKE ? OR LastName LIKE ?) OR CONCAT(FirstName, ' ', LastName) LIKE ?";

            try ( PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, "%" + condition.trim() + "%");
                pst.setString(2, "%" + condition.trim() + "%");
                pst.setString(3, condition.trim());

                try ( ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String userId = rs.getString("UserId");
                        String firstName = rs.getString("FirstName");
                        String lastName = rs.getString("LastName");
                        Date dob = rs.getDate("DateOfBirth");
                        String sex = rs.getString("Gender");
                        String country = rs.getString("Country");
                        String phone = rs.getString("Phone");
                        String email = rs.getString("Email");
                        String password = rs.getString("Password");
                        String avatar = rs.getString("ProfilePicture");

                        User user = new User(userId, firstName, lastName, dob, sex, country, phone, email, password, avatar);
                        res.add(user);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public User checkAccessToHome(String id) {
        User res = null;
        ArrayList<User> check = selectAll();
        for (User user : check) {
            if (Util.encryptPassword(user.getUserID()).equals(id)) {
                res = user;
                break; // No need to continue once found
            }
        }
        return res;
    }

    public boolean checkDuplicateEmail(String email) {
        ArrayList<User> check = selectAll();
        for (User user : check) {
            if (email.trim().equals(user.getEmail())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDuplicatePhone(String phone) {
        ArrayList<User> check = selectAll();
        for (User user : check) {
            if (phone.trim().equals(user.getPhone())) {
                return false;
            }
        }
        return true;
    }
}
