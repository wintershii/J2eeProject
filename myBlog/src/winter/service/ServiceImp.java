package winter.service;

import winter.dao.ArticleDao;
import winter.dao.DaoImp;
import winter.dao.UserDao;
import winter.pojo.Article;
import winter.pojo.ArticleDescribe;
import winter.pojo.User;

import java.util.List;

public class ServiceImp implements ArticleService,UserService {
    ArticleDao ad = new DaoImp();
    UserDao ud = new DaoImp();
    @Override
    public void articleSubmitService(Article article) {
        ad.articleSubmitDao(article);
    }

    @Override
    public List<ArticleDescribe> articleListGetService(int id) {
        return ad.articleListGetDao(id);
    }

    @Override
    public Article articleGetService(int id) {
        return ad.articleGetDao(id);
    }

    @Override
    public void articleDeleteService(int id) {
        ad.articleDeleteDao(id);
    }

    @Override
    public Article markdownGetService(int id) {
        return ad.markdownGetDao(id);
    }

    @Override
    public void articleUpdateService(int id, String title, String markdown, String essay) {
        ad.articleUpdateDao(id,title,markdown,essay);
    }

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

    @Override
    public User userGetService(int id) {
        return ud.userGetDao(id);
    }
}
