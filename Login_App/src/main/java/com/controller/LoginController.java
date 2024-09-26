package com.controller;
import com.model.Login;
import com.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller

public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping("/signup")
    public ModelAndView signup(HttpServletRequest request) {
        Login login = new Login();
        login.setEmailid(request.getParameter("emailid"));
        login.setPassword(request.getParameter("password"));
        login.setTypeofuser(request.getParameter("typeofuser"));
        loginService.signup(login);
        return new ModelAndView("redirect:/login.jsp");
    }
    @PostMapping("/signin")
    public ModelAndView signin(HttpServletRequest request) {
        String emailid = request.getParameter("emailid");
        String password = request.getParameter("password");
        String typeofuser = request.getParameter("typeofuser");
        boolean isValidUser = loginService.signin(emailid, password, typeofuser);
        if (isValidUser) 
        {
            if ("admin".equals(typeofuser))
            {
                return new ModelAndView("adminHome");
            }
            else if ("customer".equals(typeofuser)) 
            {
                return new ModelAndView("customerHome");

            } 
            else 
            {
                return new ModelAndView("login", "error", "Invalid user type.");

            }

        } else 
        {

            return new ModelAndView("login", "error", "Invalid email or password.");

        }

    }

}
