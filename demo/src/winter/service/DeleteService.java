package winter.service;

import winter.dao.DeleteDao;

public class DeleteService {
    DeleteDao dd = new DeleteDao();
    public void deleteService(int id){
        dd.deleteDao(id);
    }
}
