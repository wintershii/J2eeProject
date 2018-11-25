package winter.servlet;

import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;
import winter.pojo.User;
import winter.service.ArticleService;
import winter.service.ServiceImp;
import winter.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UserServlet",urlPatterns = {"/user/*"})
public class UserServlet extends HttpServlet {
    UserService us = new ServiceImp();
    ArticleService as = new ServiceImp();
    Logger logger = Logger.getLogger(UserServlet.class);

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
     * 登录方法
     * @param req
     * @param resp
     * @throws IOException
     */
    public void login(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //设置请求编码格式
            req.setCharacterEncoding("utf-8");

        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取账户用户名与密码
        String account = req.getParameter("account");

        String pwdReal = req.getParameter("pwd");

        String pwd = encodingByMd5(pwdReal);

        //调用服务层方法，返回用户对象
        User u = us.loginCheckService(account,pwd);
        if (u != null){
            logger.debug(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ":" + u.getAccount() + " "+ "登陆成功");
            HttpSession hs = req.getSession();
            hs.setAttribute("user",u);

            try {
                resp.sendRedirect(req.getContextPath() + "/article/showList?id=0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            HttpSession hs = req.getSession();
            hs.setAttribute("loginFail",1);
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }

    /**
     * 注册方法
     * @param req
     * @param resp
     * @throws IOException
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        String account = req.getParameter("account");
        String pwdReal = req.getParameter("pwd");
        String pwd = encodingByMd5(pwdReal);
        String name = req.getParameter("name");
        int sex = Integer.parseInt(req.getParameter("sex"));
        String birth = req.getParameter("birth");
        String signature = req.getParameter("signature");
        us.registerService(account,pwd,name,sex,birth,signature);
        logger.debug(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ":" + account + " "+ "注册成功");
        HttpSession hs = req.getSession();
        hs.setAttribute("register",1);
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }


    /**
     * 退出登录方法
     * @param req
     * @param resp
     * @throws IOException
     */
    public void quit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        HttpSession hs = req.getSession();
        User u = (User) hs.getAttribute("user");
        logger.debug(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ":" + u.getName() + "退出登陆");
        hs.invalidate();

        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

    /**
     * 修改信息方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name");
        int sex = Integer.parseInt(req.getParameter("sex"));
        String birth = req.getParameter("birth");
        String signature = req.getParameter("signature");
        int id = Integer.parseInt(req.getParameter("id"));
        us.userUpdateService(name,sex,birth,signature,id);
        HttpSession hs = req.getSession();
        User u = (User) hs.getAttribute("user");
        u.setName(name);
        u.setSex(sex);
        try {
            u.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse(birth));
            u.setSignature(signature);
            hs.setAttribute("user",u);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logger.debug(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ":" + u.getAccount() + " "+ "信息修改成功");
        resp.sendRedirect(req.getContextPath() + "/article/showList?id=0");
    }

    /**
     * 访问他人主页方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void otherHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        int aid = Integer.parseInt(req.getParameter("aid"));
        User u = us.userGetService(aid);
        req.setAttribute("user",u);
        req.getRequestDispatcher("/article/showList?id=" + u.getId() + "&other=1").forward(req,resp);
    }

    /**
     * 用MD5对密码进行加密
     * @param pwdReal
     * @return
     */
    private String encodingByMd5(String pwdReal) {
        byte[] secretBytes = null;
        try {

            secretBytes = MessageDigest.getInstance("MD5").digest(pwdReal.getBytes());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String md5code = new BigInteger(1,secretBytes).toString(16);
        String pwd = md5code.substring(0,16);
        return pwd;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


}
