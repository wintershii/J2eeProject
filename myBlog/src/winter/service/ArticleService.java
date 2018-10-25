package winter.service;

import winter.pojo.Article;
import winter.pojo.ArticleDescribe;

import java.util.List;

public interface ArticleService {
    void articleSubmitService(Article article);
    List<ArticleDescribe> articleListGetService(int id);
    Article articleGetService(int id);
    void articleDeleteService(int id);
    Article markdownGetService(int id);
    void articleUpdateService(int id,String title,String markdown,String essay);
}
