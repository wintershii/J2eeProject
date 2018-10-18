package winter.filters;

import winter.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "loginFilter",urlPatterns = {"/main.jsp","/update.jsp","/update","/update1"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession hs = ((HttpServletRequest)servletRequest).getSession();
        User u = (User) hs.getAttribute("user");
        if (u == null){
            servletRequest.getRequestDispatcher("index.jsp").forward(servletRequest,servletResponse);
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
