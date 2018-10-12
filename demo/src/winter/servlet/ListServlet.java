package winter.servlet;

import winter.poju.Student;
import winter.service.ListGetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "list",urlPatterns = {"/list"})
public class ListServlet extends HttpServlet {
    ListGetService lgs = new ListGetService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<Student> list = null;
        list = lgs.listGetService();
        if (list != null){
            req.setAttribute("student",list);
        }
        req.getRequestDispatcher("show/list.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
