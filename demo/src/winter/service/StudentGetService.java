package winter.service;

import winter.dao.StudentGetDao;
import winter.poju.Student;

public class StudentGetService {
    StudentGetDao sgd = new StudentGetDao();
    public Student studentGetService(int id){
        return sgd.studentGetDao(id);
    }
}
