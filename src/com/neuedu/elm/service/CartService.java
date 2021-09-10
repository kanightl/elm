package com.neuedu.elm.service;

import com.neuedu.elm.entity.Cart;

import java.util.List;

public interface CartService {
    public List<Cart> listCart(Cart c) ;
    public int saveCart(Cart c) ;
    public int removeCart(Cart c) ;
    public int updateCart(Cart c) ;
}
