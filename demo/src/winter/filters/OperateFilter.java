package winter.filters;

import winter.poju.Student;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "operate",urlPatterns = {"/list","/show/add.jsp","/show/page.jsp","/show/person.jsp"})
public class OperateFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest)servletRequest;
        Student student = (Student) hsr.getSession().getAttribute("stu");
        if (student == null){
            servletRequest.getRequestDispatcher("index.jsp").forward(servletRequest,servletResponse);
        }
            filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
