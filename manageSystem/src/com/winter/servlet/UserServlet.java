package com.winter.servlet;

import com.winter.poju.User;
import com.winter.service.UserSerciceImpl;
import com.winter.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "user",urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
    //声明日志对象
    Logger logger = Logger.getLogger(UserServlet.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取操作符
        String oper = req.getParameter("oper");

        if ("login".equals(oper)){
            //调用登陆处理方法
            checkUserLogin(req,resp);
        } else if ("reg".equals(oper)){
            //调用注册功能

        }  else if ("out".equals(oper)){
            //调用退出功能
            userOut(req,resp);

        }else {
            System.out.println("没有找到对应操作符" + oper);
            logger.debug("没有找到对应操作符");
        }

            }

    private void userOut(HttpServletRequest req, HttpServletResponse resp) {
        //获取session对象
        HttpSession hs = req.getSession();
        //强制销毁session
        hs.invalidate();
        //重定向到登陆页面
        try {
            resp.sendRedirect("index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //处理登陆
    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) {
        //获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println(uname + ":" + pwd);

        //处理请求信息
            //获取service层对象
        UserService us = new UserSerciceImpl();
            //校验
        User u = us.checkUserLoginService(uname,pwd);

        //响应处理结果
        if (u != null){
            //获取session对象
            HttpSession hs = req.getSession();
            //将用户数据存储到session中
            hs.setAttribute("user",u);
            //重定向
            try {
                resp.sendRedirect("main/main.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            req.setAttribute("flag",0);
            //请求转发
            try {
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

    }

}
