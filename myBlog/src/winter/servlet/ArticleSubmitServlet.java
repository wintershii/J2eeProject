package winter.servlet;

import winter.pojo.Article;
import winter.service.ArticleService;
import winter.service.ServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ArticleSubmitServlet",urlPatterns = {"/article"})
public class ArticleSubmitServlet extends HttpServlet {
    ArticleService as = new ServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        String title = req.getParameter("title");
        String essay = req.getParameter("essay");
        String author = req.getParameter("author");
        int aid = Integer.parseInt(req.getParameter("aid"));
        Date date = new Date();
        int views = 0;
        Article article = new Article(0,title,author,aid,date,essay,views);
        as.articleSubmitService(article);
        resp.sendRedirect(req.getContextPath() + "/show?id=0");
    }
}
