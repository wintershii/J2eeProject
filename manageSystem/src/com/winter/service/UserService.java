package com.winter.service;

import com.winter.poju.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {
    /**
     * 校验用户登陆
     * @param uname 用户名
     * @param pwd 密码
     * @return 返回查询到的用户信息
     */
    User checkUserLoginService(String uname, String pwd);

    int userChangePwdService(String newPwd, int uid);

    List<User> userShowService();

    int userRegService(User u);
}
