package winter.service;

import winter.dao.AddDao;
import winter.poju.Student;

public class AddService {
    AddDao ad = new AddDao();
    public void addService(Student student){
        ad.addDao(student);
    }
}
