package winter.servlet;

import org.apache.log4j.Logger;
import winter.pojo.Article;
import winter.pojo.ArticleDescribe;
import winter.service.ArticleService;
import winter.service.ServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ArticleServlet",urlPatterns = {"/article/*"})
public class ArticleServlet extends HttpServlet {
    ArticleService as = new ServiceImp();
    Logger logger = Logger.getLogger(ArticleServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlPattern = req.getRequestURI();
        String[] url = urlPattern.split("/");
        String methodName = url[2];

        try {
            //利用反射获取url要调用的方法名
            Method method = getClass().getDeclaredMethod(methodName,
                    HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示文章列表方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        List<ArticleDescribe> list = as.articleListGetService(id);
        req.setAttribute("articleList",list);
        if (req.getParameter("other") == null){
            req.getRequestDispatcher("/main.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("/homePage.jsp").forward(req,resp);
        }
    }

    /**
     * 提交文章方法
     * @param req
     * @param resp
     * @throws IOException
     */
    public void submit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        String title = req.getParameter("title");
        String essay = req.getParameter("essay");
        String markdown = req.getParameter("markdown");
        System.out.println(markdown);
        String author = req.getParameter("author");
        int aid = Integer.parseInt(req.getParameter("aid"));
        Date date = new Date();
        int views = 0;
        Article article = new Article(0,title,author,aid,date,essay,markdown,views);
        as.articleSubmitService(article);
        resp.sendRedirect(req.getContextPath() + "/article/showList?id=0");
    }

    /**
     * 显示文章方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void showSingle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        Article article = as.articleGetService(id);
        req.setAttribute("article",article);
        req.getRequestDispatcher("/articleShow.jsp").forward(req,resp);
    }

    /**
     * 文章删除方法
     * @param req
     * @param resp
     * @throws IOException
     */
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        as.articleDeleteService(id);
        logger.debug(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ":文章" + id + "被作者删除");
        resp.sendRedirect(req.getContextPath() + "/article/showList?id=0");
    }

    /**
     * 编辑文章方法(前)
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void preUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        Article titleAndMarkdown = as.markdownGetService(id);
        String title = titleAndMarkdown.getTitle();
        String markdown = titleAndMarkdown.getMarkdown();

        req.setAttribute("title",title);
        req.setAttribute("preMarkdown",markdown);
        req.setAttribute("id",id);
        req.getRequestDispatcher("/articleUpdate.jsp").forward(req,resp);
    }

    /**
     * 编辑文章方法(后)
     * @param req
     * @param resp
     * @throws IOException
     */
    public void postUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");


        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String markdown = req.getParameter("markdown");
        String essay = req.getParameter("essay");

        as.articleUpdateService(id,title,markdown,essay);

        resp.sendRedirect(req.getContextPath() + "/article/showSingle?id=" + id);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
