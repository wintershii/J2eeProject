package servlet;

import pojo.User;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 *  使用ServletContext对象完成网页计数器
 *      在用户登陆校验中创建计数器并自增，然后存储到ServletContext对象中
 *      在主页里取出计数器数据显示给用户即可
 */
@WebServlet(name = "login",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
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
        if (u != null){
            //req.getRequestDispatcher("main").forward(req,resp);
            Cookie c = new Cookie("uid",u.getUid()+"");
            c.setMaxAge(3*24*3600);

            resp.addCookie(c);
            //将数据存储到session对象中
            HttpSession hs = req.getSession();
            hs.setAttribute("user",u);
            //创建网页计数器
                //获取计数数据
            ServletContext sc = req.getServletContext();
            if (sc.getAttribute("nums") != null) {
                int num = (int) sc.getAttribute("nums");
                //自增
                    num++;
                //再次存储到ServletContext中
                sc.setAttribute("nums", num);
            } else {
                sc.setAttribute("nums",1);
            }
            resp.sendRedirect("main");

        } else{
            //使用request对象实现不同servlet的数据流转
            req.setAttribute("str","用户名或密码错误");
            //请求转发
            req.getRequestDispatcher("page").forward(req,resp);
            return;
        }
    }
}
