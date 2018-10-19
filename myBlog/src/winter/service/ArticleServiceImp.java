package winter.service;

import winter.dao.ArticleDao;
import winter.dao.ArticleDaoImp;
import winter.pojo.Article;
import winter.pojo.ArticleDescribe;

import java.util.List;

public class ArticleServiceImp implements ArticleService{
    ArticleDao ad = new ArticleDaoImp();
    @Override
    public void articleSubmitService(Article article) {
        ad.articleSubmitDao(article);
    }

    @Override
    public List<ArticleDescribe> articleListGetService(int id) {
        return ad.articleListGetDao(id);
    }

    @Override
    public Article articleGetService(int id) {
        return ad.articleGetDao(id);
    }
}
