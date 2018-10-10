package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        Map<String,String> countries = new HashMap<>();
        countries.put("ch","Beijing");
        countries.put("us","Huashengdun");
        servletContext.setAttribute("countries",countries);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
