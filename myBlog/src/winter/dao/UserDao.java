package winter.dao;

import winter.pojo.User;

public interface UserDao {
    User loginCheckDao(String account,String pwd);
    void registerDao(String account, String pwd, String name, int sex, String birth, String signature);
    void userUpdateDao(String name,int sex,String birth,String signature,int id);

}
