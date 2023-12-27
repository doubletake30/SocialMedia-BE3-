/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.dao.UserDAO;
import utils.Util;

/**
 *
 * @author ADMIN
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String userId = UserDAO.getInstance().login(email, password);
        if (!userId.equals("")) {
            Cookie cookie = new Cookie("id", Util.encryptPassword(userId)); 
            resp.addCookie(cookie);
            resp.sendRedirect("home");
        } else {
            req.setAttribute("error", "Wrong email or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        
    }
}
