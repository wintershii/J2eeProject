package winter.service;

import winter.pojo.User;

public interface UserService {
    User loginCheckService(String account,String pwd);
    void registerService(String account,String pwd,String name,int sex,String birth,String signature);
}
