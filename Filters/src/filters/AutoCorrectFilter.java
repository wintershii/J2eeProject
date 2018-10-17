package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

@WebFilter(filterName = "AutoCorrectFilter",urlPatterns = {"/solve.jsp"})
public class AutoCorrectFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filterConfig.getServletContext();
        filterConfig.getFilterName();
        filterConfig.getInitParameterNames();
        filterConfig.getInitParameter("");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        AutoCorectHttpServletRequestWrapper wrapper = new
                AutoCorectHttpServletRequestWrapper(httpServletRequest);
        filterChain.doFilter(wrapper,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

class AutoCorectHttpServletRequestWrapper extends HttpServletRequestWrapper{

    private HttpServletRequest httpServletRequest;
    public AutoCorectHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.httpServletRequest = request;
    }

    @Override
    public String getParameter(String name) {
        return autoCorrect(httpServletRequest.getParameter(name));
    }

    private String autoCorrect(String value){
        if (value == null){
            return null;
        }
//        value = value.trim();
//        int length = value.length();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < length; i++){
//            char c = value.charAt(i);
//            if (c != ' '){
//                sb.append(c);
//            }
//
//        }
//        return sb.toString();
        value = value.replaceAll(" ","");
        return value;
    }
}
