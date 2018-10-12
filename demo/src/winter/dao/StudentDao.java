package winter.dao;

import winter.poju.Student;

import java.util.Date;
import java.util.List;

public interface StudentDao {
    Student loginCheckDao(String uname, String pwd);
    public void addDao(Student student);
    public void deleteDao(int id);
    public List<Student> listGetDao();
    public Student studentGetDao(int id);
    public void updateDao(int id, String name, String classnum, Date entryDate);
}
