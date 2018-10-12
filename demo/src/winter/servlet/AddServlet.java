package winter.servlet;

import org.apache.log4j.Logger;
import winter.poju.Student;
import winter.service.StudentService;
import winter.service.StudentServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "add",urlPatterns = {"/add"})
public class AddServlet extends HttpServlet {
    Logger logger = Logger.getLogger(AddServlet.class);
    StudentService ss = new StudentServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String name = req.getParameter("name");
        String classnum = req.getParameter("class");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date entryDate = null;
        try {
            entryDate = sdf.parse(req.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Student student = new Student(uname,pwd,name,classnum,entryDate);
        ss.addService(student);
        logger.debug(new Date() + ":" + "添加新用户" + student.getUname() + ":" + student.getName());
        resp.sendRedirect("/list");
    }
}
