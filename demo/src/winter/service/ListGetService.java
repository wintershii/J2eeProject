package winter.service;

import winter.dao.ListGetDao;
import winter.poju.Student;

import java.util.List;

public class ListGetService {
    ListGetDao lgd = new ListGetDao();
    public List<Student> listGetService(){
        return  lgd.listGetDao();
    }
}
