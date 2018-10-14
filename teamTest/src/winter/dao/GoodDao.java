package winter.dao;

import winter.poju.Good;

import java.util.List;

public interface GoodDao {
    List<Good> listGetDao();
    void goodAddDao(Good g);
    void goodDeleteDao(int id);
    Good goodGetDao(int id);
    void goodUpdateDao(Good g);
    List<Good> goodSearchDao(String info);
}
