package com.neuedu.elm.service;

import com.neuedu.elm.dao.CartDao;
import com.neuedu.elm.dao.CartDaoImpl;
import com.neuedu.elm.entity.Cart;
import com.neuedu.elm.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDao dao=new CartDaoImpl();

    @Override
    public List<Cart> listCart(Cart c) {
        List<Cart> list=new ArrayList<>();
        try {
            DBUtil.getConnection();
            list=dao.listCart(c);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }

    @Override
    public int saveCart(Cart c) {
        int i=0;
        try {
            DBUtil.getConnection();
            i=dao.saveCart(c);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }

        return i;
    }

    @Override
    public int removeCart(Cart c) {
        int i=0;
        try {
            DBUtil.getConnection();
            i=dao.removeCart(c);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }

        return i;
    }

    @Override
    public int updateCart(Cart c) {
        int i=0;
        try {
            DBUtil.getConnection();
            i=dao.updateCart(c);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }

        return i;
    }
}
