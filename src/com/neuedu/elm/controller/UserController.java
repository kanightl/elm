package com.neuedu.elm.controller;

import com.neuedu.elm.entity.User;
import com.neuedu.elm.service.UserService;
import com.neuedu.elm.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController {

    private UserService service=new UserServiceImpl();

   //  http://localhost:8890/elm/UserController/saveUser?userId=tom01&password=123&userName=张三&userSex=1&userImg=
    public Object saveUser(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String userId=req.getParameter("userId");
        String password=req.getParameter("password");
        String userName = req.getParameter("userName");
        String userSex = req.getParameter("userSex");
        int userSex2=0;
        if (userSex!=null && !"".equals(userSex)){
            userSex2 =Integer.valueOf(userSex);
        }
        String userImg = req.getParameter("userImg");
        User u=new User(userId,password,userName,userSex2,userImg,-1);
        int i=service.saveUser(u);
        return i;
    }

    //  http://localhost:8890/elm/UserController/getUserByIdByPass?userId=tom01&password=123
    public Object getUserByIdByPass(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String userId=req.getParameter("userId");
        String password=req.getParameter("password");

        User u2=service.getUserByIdByPass(userId,password);
        if (u2!=null){
            req.getSession().setAttribute("login_user",u2);
        }
        return u2;
    }

    //  http://localhost:8890/elm/UserController/getUserById?userId=tom01
    public Object getUserById(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String userId=req.getParameter("userId");
        User u2=service.getUserById(userId);

        return u2;
    }
}
