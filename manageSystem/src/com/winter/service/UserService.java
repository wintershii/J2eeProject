package com.winter.service;

import com.winter.poju.User;

public interface UserService {
    /**
     * 校验用户登陆
     * @param uname 用户名
     * @param pwd 密码
     * @return 返回查询到的用户信息
     */
    User checkUserLoginService(String uname, String pwd);

    void userChangePwdService(String newPwd, int uid);
}
