package winter.servlet;

import winter.service.GoodService;
import winter.service.GoodServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete",urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {
    GoodService gs = new GoodServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        gs.goodDeleteService(id);
        resp.sendRedirect( req.getContextPath() + "/list");
    }
}
