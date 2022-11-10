package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // check if a user is already logged in
        if (request.getSession().getAttribute("user") != null) {
            // if a session exists and the user has already logged in, send them to profile
            response.sendRedirect("/profile");
            return;
        }

        // if a session does not exist, show them the login form.
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Data coming from our form in login.jsp with the name attributes of "username" and "password".
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Go into DAO to find the user by the username we received from the form.
        User user = DaoFactory.getUsersDao().findByUsername(username);
        // if the user does not exist or not found, redirect to /login
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

        // Check to see if password sent via form matches the hashed password in our DB.
        boolean validAttempt = BCrypt.checkpw(password, user.getPassword());

        if (validAttempt) {
            // if the passwords match, start a session, assign the user object, and redirect to their profile page.
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        } else {
            // if the passwords don't match, redirect to login for another attempt.
            response.sendRedirect("/login");
        }
    }
}
