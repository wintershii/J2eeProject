package winter.servlet;

import org.apache.log4j.Logger;
import winter.pojo.User;
import winter.service.ServiceImp;
import winter.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AftUpdateServlet",urlPatterns = {"/update1"})
public class AftUpdateServlet extends HttpServlet {
    UserService us = new ServiceImp();
    Logger logger = Logger.getLogger(AftUpdateServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        resp.sendRedirect(req.getContextPath() + "/show?id=0");

    }
}
