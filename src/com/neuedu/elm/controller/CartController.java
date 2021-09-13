package com.neuedu.elm.controller;

import com.neuedu.elm.entity.Cart;
import com.neuedu.elm.service.CartService;
import com.neuedu.elm.service.CartServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CartController {

    private CartService service= new  CartServiceImpl();

    //http://localhost:8890/elm/CartController/listCart?userId=tom01
    public Object listCart(HttpServletRequest req, HttpServletResponse response) throws Exception{
        List<Cart>  list=new ArrayList<>();
        Cart c=new Cart();
        if (req.getParameter("businessId")!=null){
            c.setBusinessId(Integer.valueOf(req.getParameter("businessId")));
        }
        if (req.getParameter("userId")!=null){
            c.setUserId(req.getParameter("userId"));
        }
        list=service.listCart(c);
        return list;

    }

    //http://localhost:8890/elm/CartController/saveCart?foodId=2&businessId=1&userId=tom01
    public Object saveCart(HttpServletRequest req, HttpServletResponse response) throws Exception{
        Cart c=new Cart();

            c.setFoodId(Integer.valueOf(req.getParameter("foodId")));
            c.setBusinessId(Integer.valueOf(req.getParameter("businessId")));
            c.setUserId(req.getParameter("userId"));

        int i=service.saveCart(c);
        return i;

    }

    //http://localhost:8890/elm/CartController/removeCart?foodId=1&businessId=1&userId=tom01
    public Object removeCart(HttpServletRequest req, HttpServletResponse response) throws Exception{
        Cart c=new Cart();
        c.setFoodId(Integer.valueOf(req.getParameter("foodId")));
        c.setBusinessId(Integer.valueOf(req.getParameter("businessId")));
        c.setUserId(req.getParameter("userId"));
        int i=service.removeCart(c);
        return i;
    }

    //http://localhost:8890/elm/CartController/updateCart?foodId=2&businessId=1&userId=tom01&quantity=2
    public Object updateCart(HttpServletRequest req, HttpServletResponse response) throws Exception{
        Cart c=new Cart();
        c.setFoodId(Integer.valueOf(req.getParameter("foodId")));
        c.setBusinessId(Integer.valueOf(req.getParameter("businessId")));
        c.setUserId(req.getParameter("userId"));
        c.setQuantity(Integer.valueOf(req.getParameter("quantity")));
        int i=service.updateCart(c);
        return i;
    }
}
