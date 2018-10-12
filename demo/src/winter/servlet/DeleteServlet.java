package winter.servlet;

import org.apache.log4j.Logger;
import winter.service.DeleteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "delete",urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {
    Logger logger = Logger.getLogger(DeleteServlet.class);
    DeleteService ds = new DeleteService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int id= Integer.parseInt(req.getParameter("id"));
        ds.deleteService(id);
        logger.debug(new Date() + ":" + id + "用户被删除");
        resp.sendRedirect("/list");
    }
}
