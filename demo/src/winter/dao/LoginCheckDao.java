package winter.dao;

import winter.poju.Student;

public interface LoginCheckDao {
    Student loginCheckDao(String uname, String pwd);
}
