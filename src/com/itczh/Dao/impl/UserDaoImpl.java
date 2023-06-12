package com.itczh.Dao.impl;

import com.itczh.bean.User;
import com.itczh.Dao.BaseDaoImpl;
import com.itczh.Dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Override
    public User findUserByUsername(String username) {
        String sql = "select * from users where username=?";
        return this.getBean(User.class,sql,username);
    }

    @Override
    public boolean addUser(User user) {
        String sql = "insert into users values(null,?,?,?,?)";
        int update = this.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getAddress());
        if (update > 0) {
            return true;
        } else {
            return false;
        }
    }
}
