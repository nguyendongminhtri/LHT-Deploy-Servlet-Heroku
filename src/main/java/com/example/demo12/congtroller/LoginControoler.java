package com.example.demo12.congtroller;

import com.example.demo12.model.Users;
import com.example.demo12.service.UserServiceImpl;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginControoler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginControoler() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        String pageLink = "";
        if(session.getAttribute("user")!=null){
            pageLink = "WEB-INF/form-login/profile.jsp";
        } else {
            pageLink = "WEB-INF/form-login/login.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(pageLink);
        dispatcher.forward(request,response);

//        System.out.println("check session user  -->"+session.getAttribute("user"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserServiceImpl userService = new UserServiceImpl();
        Users users = userService.findByUsernameAndPassword(username,password);
        String destPage = "WEB-INF/form-login/login.jsp";
        if(users !=null){
            HttpSession session = request.getSession();
            session.setAttribute("user", users);
            System.out.println("Check session user luc login ==>"+session.getAttribute("user"));
            request.setAttribute("user", users);

            destPage = "WEB-INF/form-login/profile.jsp";
        }else {
            String message = "Login failed! Please check username/password";
            request.setAttribute("message", message);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request,response);
    }

}
