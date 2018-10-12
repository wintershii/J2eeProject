package winter.service;

import winter.dao.UpdateDao;

import java.util.Date;

public class UpdateService {
    UpdateDao ud = new UpdateDao();
    public void updateService(int id, String name, String classnum, Date date){
        ud.updateDao(id,name,classnum,date);
    }
}
