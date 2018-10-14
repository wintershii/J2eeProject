package winter.service;

import winter.poju.Good;

import java.util.List;

public interface GoodService {
    List<Good> listGetService();
    void goodAddService(Good g);
    void goodDeleteService(int id);
    Good goodGetService(int id);
    void goodUpdateService(Good g);
    List<Good> goodSearch(String info);
}
