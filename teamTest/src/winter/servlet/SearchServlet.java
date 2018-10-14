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
import java.util.List;

@WebServlet(name = "search",urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    GoodService gs = new GoodServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String info = req.getParameter("info");
        List<Good> list = gs.goodSearch(info);
        req.setAttribute("list",list);
        req.getRequestDispatcher("show.jsp").forward(req,resp);
    }
}
