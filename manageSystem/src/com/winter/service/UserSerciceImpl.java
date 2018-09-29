package com.winter.service;

import com.winter.dao.UserDao;
import com.winter.dao.UserDaoImpl;
import com.winter.poju.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


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

    //修改用户密码
    @Override
    public int userChangePwdService(String newPwd, int uid) {
        logger.debug(uid + ":发起密码修改请求");
        int index = ud.userChangePwdDao(newPwd,uid);
        if (index > 0){
            logger.debug(uid + ":密码修改成功");
        } else {
            logger.debug(uid + ":密码修改失败");
        }
        return index;
    }

    //获取所有的用户信息
    @Override
    public List<User> userShowService() {
        List<User> list = ud.userShowDao();
        logger.debug("显示所有用户信息:" + list);
        return list;
    }

    @Override
    public int userRegService(User u) {
        int index = ud.userRegDao(u);
        return index;
    }
}
