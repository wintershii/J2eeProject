import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session学习
 *
 */
@WebServlet(name = "ss",urlPatterns = {"/ss"})
public class SessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String name = "张三";
        //处理请求信息
            //创建session对象
        HttpSession hs = req.getSession();
        //hs.setMaxInactiveInterval(5);
        System.out.println(hs.getId());
        //hs.invalidate();
        //存储数据
        hs.setAttribute("name",name);
        //响应处理结果
            //直接向应
        resp.getWriter().write("session学习");
            //请求转发
    }
}
