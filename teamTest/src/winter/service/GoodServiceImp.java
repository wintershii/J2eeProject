package winter.service;

import winter.dao.GoodDao;
import winter.dao.GoodDaoImp;
import winter.poju.Good;

import java.util.List;

public class GoodServiceImp implements GoodService{
    GoodDao gd = new GoodDaoImp();
    @Override
    public List<Good> listGetService() {
        return gd.listGetDao();
    }

    @Override
    public void goodAddService(Good g) {
        gd.goodAddDao(g);
    }

    @Override
    public void goodDeleteService(int id) {
        gd.goodDeleteDao(id);
    }

    @Override
    public Good goodGetService(int id) {
        return gd.goodGetDao(id);
    }

    @Override
    public void goodUpdateService(Good g) {
        gd.goodUpdateDao(g);
    }

    @Override
    public List<Good> goodSearch(String info) {
        return gd.goodSearchDao(info);
    }

}
