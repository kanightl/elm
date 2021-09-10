package com.neuedu.elm.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController {

    // http://localhost:8890/elm/LoginController/login?uname=tom
    public Object login(HttpServletRequest req, HttpServletResponse resp){
        String uname=req.getParameter("uname");
        return "haha,"+uname;
    }
}
