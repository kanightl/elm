package com.neuedu.elm.dao;

import com.neuedu.elm.entity.User;

public interface UserDao {

    public int saveUser(User u) throws Exception;
    public User getUserByIdByPass(String id,String pass) throws  Exception;
    public User getUserById(String id) throws  Exception;
}
