/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author ADMIN
 */
import models.dao.UserDAO;
import models.dm.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Validation;

public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String dob = req.getParameter("dateOfBirth");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        String phone = req.getParameter("phone");
        
        Date dateOfBirth = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateOfBirth = dateFormat.parse(dob);
        } catch (ParseException e) {
            // Handle parsing exception
            e.printStackTrace();
            // You might want to handle the error appropriately, e.g., show an error message to the user
        }

        User user = new User(firstName, lastName, email, password, dateOfBirth, gender, country, phone);

        if (!UserDAO.getInstance().checkDuplicateEmail(email) && !Validation.checkEmail(email)) {
            req.setAttribute("error", "Email is duplicated");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else if (!Validation.checkNameCountry(firstName) || !Validation.checkNameCountry(lastName)) {
            req.setAttribute("error", "Name is not valid");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else if (!Validation.checkNameCountry(country)) {
            req.setAttribute("error", "Country is not valid");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else if (!Validation.checkPassword(password)) {
            req.setAttribute("error", "Password must not be empty, no spaces and at least six characters");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else if (!Validation.checkPhone(phone)) {
            req.setAttribute("error", "Phone is not valid or duplicated");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else {
            UserDAO.getInstance().insert(user);
            resp.sendRedirect("login.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }
}
