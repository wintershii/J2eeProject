package com.winter.service;

import com.winter.dao.UserDao;
import com.winter.dao.UserDaoImpl;
import com.winter.poju.User;
import org.apache.log4j.Logger;


public class UserSerciceImpl implements UserService{
    //声明日志对象
    Logger logger = Logger.getLogger(UserSerciceImpl.class);
    //声明Dao层对象
    UserDao ud = new UserDaoImpl();
    //用户登陆
    @Override
    public User checkUserLoginService(String uname, String pwd) {
        //打印日志
        logger.debug(uname + "发起登录请求");
        User u = ud.checkUserLoginDao(uname,pwd);
        //判断
        if (u != null){
            logger.debug(uname + "登陆成功");
        } else {
            logger.debug(uname + "登陆失败");
        }
        return u;
    }
}
