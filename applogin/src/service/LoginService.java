package service;

import pojo.User;

public interface LoginService {
    User checkLoginService(String uname, String pwd);
}
