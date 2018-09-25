import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletConfig对象
 *   如何获取在web.xml中给每个servlet单独配置的数据呢
 */
@WebServlet(name = "config",urlPatterns = {"/config"},initParams = {
        @WebInitParam(name = "name",value = "师东璇")
})
public class ServletConfigDemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig sc = this.getServletConfig();
        String name = sc.getInitParameter("name");
        System.out.println(name);
    }
}
