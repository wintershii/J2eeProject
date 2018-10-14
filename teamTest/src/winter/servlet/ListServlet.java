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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "list",urlPatterns = {"/list"})
public class ListServlet extends HttpServlet {
    GoodService gs = new GoodServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        List<Good> list = new ArrayList<>();
        list = gs.listGetService();
        if (list != null){
            req.setAttribute("goods",list);
            req.getRequestDispatcher("list.jsp").forward(req,resp);
        } else {
            req.setAttribute("isNull",1);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
