package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
@WebServlet(name = "ck",urlPatterns = {"/ck"})
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置请求编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        //处理请求信息
        //相应处理结果
            //使用Cookie进行浏览器端的数据存储
                //创建Cookie对象
                Cookie c = new Cookie("mouse","razer");
                Cookie c2 = new Cookie("what","fuck");
                //设置Cookie
                c2.setMaxAge(3*24*3600);
                //设置有效路径
                c2.setPath("/gc");
                //响应Cookie对象
                resp.addCookie(c);
                resp.addCookie(c2);
            //直接响应
        resp.getWriter().write("Cookie学习");
            //请求转发
            //重定向
        req.getSession();

    }
}
