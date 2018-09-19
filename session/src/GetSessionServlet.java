import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

@WebServlet(name = "get",urlPatterns = {"/get"})
public class GetSessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        HttpSession hs = req.getSession();
        System.out.println(hs.getId());
        String name = (String) hs.getAttribute("name");
        ServletContext sc = this.getServletContext();
        String str = (String) sc.getAttribute("str");
        resp.getWriter().write(str);
        resp.getWriter().write(name);
        //获取项目web.xml文件的全局配置
        String name2 = sc.getInitParameter("name");
        System.out.println(name2);
        Enumeration em = sc.getInitParameterNames();
        while (em.hasMoreElements()){
            System.out.println(em.nextElement());
        }
        String path = sc.getRealPath("/doc/1.txt");
        System.out.println(path);
        InputStream is = sc.getResourceAsStream("/doc/1.txt");
    }
}
