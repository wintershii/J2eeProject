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
import java.util.Date;
import java.util.List;

@WebServlet(name = "user",urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
    //声明日志对象
    Logger logger = Logger.getLogger(UserServlet.class);
    UserService us = new UserSerciceImpl();
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
            userReg(req,resp);
        } else if ("pwd".equals(oper)){
            //调用修改密码功能
            userChangePwd(req,resp);
        } else if ("show".equals(oper)){
            //调用显示用户功能
            userShow(req,resp);
        }else if ("out".equals(oper)){
            //调用退出功能
            userOut(req,resp);
        }else {
            System.out.println("没有找到对应操作符" + oper);
            logger.debug("没有找到对应操作符");
        }

            }

    private void userReg(HttpServletRequest req, HttpServletResponse resp) {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        int age = req.getParameter("age").equals("") ? 0 : Integer.parseInt(req.getParameter("age"));
        String birth = req.getParameter("birth");
        User u = new User(0,uname,pwd,sex,age,birth);
        //处理请求信息
        int index = us.userRegService(u);
        if (index > 0){
            //重定向
            try {
                HttpSession hs = req.getSession();
                hs.setAttribute("reg","true");
                resp.sendRedirect("index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

        }
    }

    //显示所有的用户信息
    private void userShow(HttpServletRequest req, HttpServletResponse resp) {
        //处理请求
            //调用service
        List<User> list = us.userShowService();
        if (list != null) {
            req.setAttribute("list",list);
            try {
                req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
    }

    private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) {
        //获取数据
        String newPwd = req.getParameter("newPwd");
        //从session中获取用户信息
        User u = (User) req.getSession().getAttribute("user");
        int uid = u.getUid();
        //处理请求
        //调用service对象
        int index = us.userChangePwdService(newPwd,uid);
        if (index > 0){
            try {
                HttpSession hs = req.getSession();
                hs.setAttribute("pwd","true");
                //重定向到登陆页面
                resp.sendRedirect("index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
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
