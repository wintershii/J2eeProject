package winter.servlet;

import org.apache.log4j.Logger;
import winter.pojo.User;
import winter.service.UserService;
import winter.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LoginServlet",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    UserService us = new UserServiceImp();
    Logger logger = Logger.getLogger(LoginServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取账户用户名与密码
        String account = req.getParameter("account");
        String pwd = req.getParameter("pwd");
        //调用服务层方法，返回用户对象
        User u = us.loginCheckService(account,pwd);
        if (u != null){
            logger.debug(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + u.getAccount()+"登陆成功");
            System.out.println(u);
        } else {

        }
    }
}