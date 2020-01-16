package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // TODO: show the registration form
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/register");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid

        // TODO: create a new user based off of the submitted information

        // TODO: if a user was successfully created, send them to their profile

        User user = new User(
//                1, // for now we'll hardcode the user id
                request.getParameter("username"),
                request.getParameter("email"),
                request.getParameter("password")
        );
        try {
            DaoFactory.getUsersDoa().insert(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/");
    }
}
