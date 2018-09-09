package servlet;

import pojo.User;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应编码格式
            resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println(uname + ":" + pwd);
        //处理请求信息
            //获取业务层对象
        LoginService ls = new LoginServiceImpl();
        User u = ls.checkLoginService(uname,pwd);
        System.out.println(u);
        //处理相应结果
    }
}
