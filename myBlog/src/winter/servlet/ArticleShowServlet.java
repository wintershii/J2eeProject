package winter.servlet;

import winter.pojo.Article;
import winter.service.ArticleService;
import winter.service.ArticleServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ArticleShowServlet",urlPatterns = {"/articlePage"})
public class ArticleShowServlet extends HttpServlet {
    ArticleService as = new ArticleServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        Article article = as.articleGetService(id);
        req.setAttribute("article",article);
        req.getRequestDispatcher("articleShow.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
