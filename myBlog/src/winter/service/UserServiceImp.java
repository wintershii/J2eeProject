package winter.service;

import winter.dao.UserDao;
import winter.dao.UserDaoImp;
import winter.pojo.Article;
import winter.pojo.ArticleDescribe;
import winter.pojo.User;

import java.util.List;

public class UserServiceImp implements UserService{
    UserDao ud = new UserDaoImp();
    //登陆校验
    @Override
    public User loginCheckService(String account, String pwd) {
        return ud.loginCheckDao(account,pwd);
    }

    //注册账户
    @Override
    public void registerService(String account, String pwd, String name, int sex, String birth, String signature) {
        ud.registerDao(account, pwd, name, sex, birth, signature);
    }

    @Override
    public void userUpdateService(String name, int sex, String birth, String signature,int id) {
        ud.userUpdateDao(name,sex,birth,signature,id);
    }



}
