package winter.servlet;

import org.apache.log4j.Logger;
import winter.service.UpdateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "aftUpdate",urlPatterns = {"/update2"})
public class AftUpdateServlet extends HttpServlet {
    Logger logger = Logger.getLogger(AftUpdateServlet.class);
    UpdateService us = new UpdateService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        String classnum = req.getParameter("class");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date entryDate = null;
        try {
            entryDate = sdf.parse(req.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(req.getParameter("id"));
        us.updateService(id,name,classnum,entryDate);
        logger.debug(new Date() + ":" + "id = " + id + "信息修改成功");
        resp.sendRedirect("/list");
    }
}
