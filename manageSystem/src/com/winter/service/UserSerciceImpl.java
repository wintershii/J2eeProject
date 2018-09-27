package com.winter.service;

import com.winter.dao.UserDao;
import com.winter.dao.UserDaoImpl;
import com.winter.poju.User;

public class UserSerciceImpl implements UserService{
    UserDao ud = new UserDaoImpl();
    //用户登陆
    @Override
    public User checkUserLoginService(String uname, String pwd) {
        User u = ud.checkUserLoginDao(uname,pwd);
        return u;
    }
}
