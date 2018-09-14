package service.impl;

import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import pojo.User;
import service.LoginService;

public class LoginServiceImpl implements LoginService {
    //创建Dao层对象
    LoginDao ld = new LoginDaoImpl();
    @Override
    public User checkLoginService(String uname, String pwd) {
        return ld.chechLoginDao(uname,pwd);
    }

    @Override
    public User checkUidService(String uid) {
        return ld.checkUidDao(uid);
    }
}
