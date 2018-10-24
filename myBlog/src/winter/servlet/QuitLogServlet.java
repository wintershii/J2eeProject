package winter.servlet;

import org.apache.log4j.Logger;
import winter.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "QuitLogServlet",urlPatterns = {"/quit"})
public class QuitLogServlet extends HttpServlet {
    Logger logger = Logger.getLogger(QuitLogServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        HttpSession hs = req.getSession();
        User u = (User) hs.getAttribute("user");
        logger.debug(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ":" + u.getName() + "退出登陆");
        hs.invalidate();

        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
