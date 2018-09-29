package com.winter.dao;

import com.winter.poju.User;

public interface UserDao {
    /**
     * 根据用户名和密码查询用户信息
     * @param uname
     * @param pwd
     * @return
     */
    User checkUserLoginDao(String uname, String pwd);

    void userChangePwdDao(String newPwd, int uid);
}
