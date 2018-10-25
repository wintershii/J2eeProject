package winter.dao;

import winter.pojo.Article;
import winter.pojo.ArticleDescribe;

import java.util.List;

public interface ArticleDao {
    void articleSubmitDao(Article article);
    List<ArticleDescribe> articleListGetDao(int id);
    Article articleGetDao(int id);
    void articleDeleteDao(int id);
    Article markdownGetDao(int id);
    void articleUpdateDao(int id,String title,String markdown,String essay);
}
