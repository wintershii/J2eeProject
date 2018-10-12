package winter.servlet;

import winter.poju.Student;
import winter.service.StudentService;
import winter.service.StudentServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "update1",urlPatterns = {"/update"})
public class PreUpdateServlet extends HttpServlet {
    StudentService ss = new StudentServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        Student student = ss.studentGetService(id);
        req.setAttribute("updateStu",student);
        req.getRequestDispatcher("show/update.jsp").forward(req,resp);
    }
}
