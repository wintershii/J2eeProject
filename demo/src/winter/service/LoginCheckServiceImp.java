package winter.service;

import winter.dao.LoginCheckDao;
import winter.dao.LoginCheckDaoImp;
import winter.poju.Student;

public class LoginCheckServiceImp implements LoginCheckSevice{
    LoginCheckDao lcd = new LoginCheckDaoImp();
    @Override
    public Student loginCheckService(String uname, String pwd) {
        Student student = lcd.loginCheckDao(uname,pwd);
        return student;
    }
}
