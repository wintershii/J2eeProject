package winter.servlet;

import winter.service.ArticleService;
import winter.service.ServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AftArticleUpdateServlet",urlPatterns = {"/articleUpdate1"})
public class AftArticleUpdateServlet extends HttpServlet {
    ArticleService as = new ServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String markdown = req.getParameter("markdown");
        String essay = req.getParameter("essay");

        as.articleUpdateService(id,title,markdown,essay);

        resp.sendRedirect(req.getContextPath() + "/articlePage?id=" + id);
    }
}
