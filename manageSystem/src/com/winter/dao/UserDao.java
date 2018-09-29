package com.winter.dao;

import com.winter.poju.User;

import java.util.List;

public interface UserDao {
    /**
     * 根据用户名和密码查询用户信息
     * @param uname
     * @param pwd
     * @return
     */
    User checkUserLoginDao(String uname, String pwd);

    int userChangePwdDao(String newPwd, int uid);

    List<User> userShowDao();

    int userRegDao(User u);
}
