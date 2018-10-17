package winter.servlet;

import winter.service.UserService;
import winter.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    UserService us = new UserServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        String account = req.getParameter("account");
        String pwd = req.getParameter("pwd");
        String name = req.getParameter("name");
        int sex = Integer.parseInt(req.getParameter("sex"));
        String birth = req.getParameter("birth");
        String signature = req.getParameter("signature");
        us.registerService(account,pwd,name,sex,birth,signature);

        HttpSession hs = req.getSession();
        hs.setAttribute("register",1);
        resp.sendRedirect(req.getContextPath() + "index.jsp");
    }
}
