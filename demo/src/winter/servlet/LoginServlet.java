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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "login",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    Logger logger = Logger.getLogger(LoginServlet.class);
    StudentService ss = new StudentServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        Student student = ss.loginCheckService(uname,pwd);
        if (student != null){
            logger.debug(new Date() +": " + uname + "登陆成功");
            HttpSession hs = req.getSession();
            hs.setAttribute("stu",student);
            resp.sendRedirect("show/page.jsp");
        } else {
            logger.debug(new Date() +": " + uname + "登陆失败");
            HttpSession hs = req.getSession();
            hs.setAttribute("check",1);
            resp.sendRedirect("index.jsp");
        }
    }
}
