package com.itczh.servlet;

import com.itczh.bean.User;
import com.itczh.Dao.UserDao;
import com.itczh.Dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        UserDao userDao = new UserDaoImpl();
        User userByUsername = userDao.findUserByUsername(username);
        if(userByUsername!=null) {
            if (userByUsername.getPassword().equals(password)) {
                request.getRequestDispatcher("login_success.html").forward(request, response);
            } else {
                request.getRequestDispatcher("login_error.html").forward(request, response);
            }
        }
        else {
            request.getRequestDispatcher("login_error.html").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
}
