import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 *  ServletContext对象学习
 */
@WebServlet(name = "sc",urlPatterns = {"/sc"})
public class ServletContextTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
            //第一种方式
        ServletContext sc = this.getServletContext();
            //第二种方式
        ServletContext sc2 = this.getServletConfig().getServletContext();
            //第三种方式
        ServletContext sc3 = req.getSession().getServletContext();

        System.out.println(sc == sc2);
        System.out.println(sc == sc3);
//        //设置请求编码格式
//        req.setCharacterEncoding("utf-8");
//        //设置响应编码格式
//        resp.setContentType("text/html;charset=utf-8");
//        //获取请求信息
//        //处理请求信息
//        //响应处理结果
        sc.setAttribute("str","ServletContext学习");

    }
}
