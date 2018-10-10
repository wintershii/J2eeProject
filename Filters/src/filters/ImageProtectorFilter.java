package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebFilter(filterName = "DownloadCounterFilter",urlPatterns = {"/index.jsp"})
public class ImageProtectorFilter implements Filter {

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Properties downloadLog;
    File logFile;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("DownloadCounterFilter");
        String appPath = filterConfig.getServletContext().getRealPath("/");
        logFile = new File(appPath,"downloadLog.txt");
        if (!logFile.exists()){
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        downloadLog = new Properties();
        try {
            downloadLog.load(new FileReader(logFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;

        final String uri = httpServletRequest.getRequestURI();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("过滤器");
                String property = downloadLog.getProperty(uri);
                if (property == null){
                    downloadLog.setProperty(uri,"1");
                } else {
                    int count = 0;
                    count = Integer.parseInt(property);
                    count++;
                    downloadLog.setProperty(uri,Integer.toString(count));
                    System.out.println(count);
                    try {
                        downloadLog.store(new FileWriter(logFile),"");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        executorService.shutdown();
    }
}
