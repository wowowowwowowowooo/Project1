package com.itczh.servlet;

import com.itczh.bean.User;
import com.itczh.Dao.UserDao;
import com.itczh.Dao.impl.UserDaoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String username = request.getParameter("username");
        String password = request.getParameter("pasword");
        String email = request.getParameter("email");
        User user = new User(0 , username , password , email);*/
        Map<String , String[]> parameterMap =  request.getParameterMap();
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        try {
            BeanUtils.populate(user , parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        User userByUsername = userDao.findUserByUsername(user.getUsername());

        if(userByUsername == null){
            userDao.addUser(user);
            request.getRequestDispatcher("Register_Success.html").forward(request , response);
        }else{
            request.getRequestDispatcher("Register_Error.html").forward(request , response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
}
