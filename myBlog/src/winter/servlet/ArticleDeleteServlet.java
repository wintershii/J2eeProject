package winter.servlet;

import org.apache.log4j.Logger;
import winter.service.ArticleService;
import winter.service.ServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ArticleDeleteServlet",urlPatterns = {"/articleDelete"})
public class ArticleDeleteServlet extends HttpServlet {
    Logger logger = Logger.getLogger(ArticleDeleteServlet.class);
    ArticleService as = new ServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        as.articleDeleteService(id);
        logger.debug(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ":文章" + id + "被作者删除");
        resp.sendRedirect(req.getContextPath() + "/show?id=0");
    }
}
