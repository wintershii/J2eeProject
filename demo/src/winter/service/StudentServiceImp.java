package winter.service;

import winter.dao.StudentDao;
import winter.dao.StudentDaoImp;
import winter.poju.Student;

import java.util.Date;
import java.util.List;

public class StudentServiceImp implements StudentService {
    StudentDao sd = new StudentDaoImp();
    @Override
    public Student loginCheckService(String uname, String pwd) {
        Student student = sd.loginCheckDao(uname,pwd);
        return student;
    }

    @Override
    public void addService(Student student) {
        sd.addDao(student);
    }

    @Override
    public void deleteService(int id) {
        sd.deleteDao(id);
    }

    @Override
    public List<Student> listGetService() {
        return sd.listGetDao();
    }

    @Override
    public Student studentGetService(int id) {
        return sd.studentGetDao(id);
    }

    @Override
    public void updateService(int id, String name, String classnum, Date date) {
        sd.updateDao(id,name,classnum,date);
    }
}
