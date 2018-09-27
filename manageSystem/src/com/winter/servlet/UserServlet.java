package com.winter.servlet;

import com.winter.poju.User;
import com.winter.service.UserSerciceImpl;
import com.winter.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "user",urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
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

        } else {
            System.out.println("没有找到对应操作符" + oper);
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
        System.out.println(u);
        //响应处理结果
        //直接响应
        //请求转发
        //重定向


    }



}
