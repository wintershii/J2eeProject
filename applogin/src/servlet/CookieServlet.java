package servlet;

import pojo.User;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Cookie信息校验
 *  1.判断请求中是否携带正确的Cookie信息，如果有则校验Cookie信息是否正确
 *  没有则请求转发给登陆界面
 *  如果校验正确，则直接响应主页面给用户，不正确则响应登陆页面给用户
 */
@WebServlet(name = "ck",urlPatterns = {"/ck"})
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
            //获取Cookie信息
        Cookie[] cks = req.getCookies();
        if (cks != null){
            //遍历Cookie信息
            String uid = "";
            for (Cookie c : cks){
                if ("uid".equals(c.getName())){
                    uid = c.getValue();
                }
            }
            //校验UID是否存在
            if ("".equals(uid)){
                //请求转发
                req.getRequestDispatcher("page").forward(req,resp);
                return;
            } else {
                //校验UID用户信息
                    //获取业务层对象
                LoginService ls = new LoginServiceImpl();
                User u = ls.checkUidService(uid);
                if (u != null){
                    //将用户数据存储到session对象中
                    HttpSession hs = req.getSession();
                    hs.setAttribute("user",u);
                    //重定向
                    resp.sendRedirect("main");
                    return;
                } else {
                    req.getRequestDispatcher("page").forward(req,resp);
                    return;
                }
            }
        } else {
            //请求转发
            req.getRequestDispatcher("page").forward(req,resp);
            return;
        }
        //处理请求信息
        //相应处理结果
            //直接响应

            //重定向
    }
}
