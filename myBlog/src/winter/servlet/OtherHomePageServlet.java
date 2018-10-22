package winter.servlet;

import winter.pojo.User;
import winter.service.ServiceImp;
import winter.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OtherHomePageServlet",urlPatterns = {"/homePage"})
public class OtherHomePageServlet extends HttpServlet {
    UserService us = new ServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        int aid = Integer.parseInt(req.getParameter("aid"));
        User u = us.userGetService(aid);
        req.setAttribute("user",u);
        req.getRequestDispatcher("/show?id=" + u.getId() + "&other=1").forward(req,resp);
    }
}
