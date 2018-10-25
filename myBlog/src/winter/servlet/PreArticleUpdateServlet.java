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

@WebServlet(name = "ArticleUpdateServlet",urlPatterns = {"/articleUpdate"})
public class PreArticleUpdateServlet extends HttpServlet {
    ArticleService as = new ServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        Article titleAndMarkdown = as.markdownGetService(id);
        String title = titleAndMarkdown.getTitle();
        String markdown = titleAndMarkdown.getMarkdown();

        req.setAttribute("title",title);
        req.setAttribute("preMarkdown",markdown);
        req.setAttribute("id",id);
        req.getRequestDispatcher("articleUpdate.jsp").forward(req,resp);
    }
}
