package winter.servlet;

import winter.poju.Good;
import winter.service.GoodService;
import winter.service.GoodServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "update",urlPatterns = {"/update"})
public class PreUpdateServlet extends HttpServlet {
    GoodService gs = new GoodServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        Good g = gs.goodGetService(id);
        req.setAttribute("good",g);
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }
}
