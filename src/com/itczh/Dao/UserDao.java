package com.itczh.Dao;

import com.itczh.bean.User;

public interface UserDao {
    User findUserByUsername(String username);
    boolean addUser(User user);
}
