package winter.service;

import winter.poju.Student;

import java.util.Date;
import java.util.List;

public interface StudentService {
    Student loginCheckService(String uname, String pwd);
    public void addService(Student student);
    public void deleteService(int id);
    public List<Student> listGetService();
    public Student studentGetService(int id);
    public void updateService(int id, String name, String classnum, Date date);
}
