package winter.service;

import winter.pojo.Article;
import winter.pojo.User;

public interface UserService {
    User loginCheckService(String account,String pwd);
    void registerService(String account,String pwd,String name,int sex,String birth,String signature);
    void userUpdateService(String name,int sex,String birth,String signature,int id);
    void articleSubmitService(Article article);
}
