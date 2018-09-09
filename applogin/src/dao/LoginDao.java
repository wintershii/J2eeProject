package dao;

import pojo.User;

public interface LoginDao {
    User chechLoginDao(String uname, String pwd);
}
