package winter.servlet;

import winter.poju.Good;
import winter.service.GoodService;
import winter.service.GoodServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "update1",urlPatterns = {"/update1"})
public class AftUpdateServlet extends HttpServlet {
    GoodService gs = new GoodServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String gType = req.getParameter("gType");
        String location = req.getParameter("location");
        String date = req.getParameter("gDate");
        int gRest = Integer.parseInt(req.getParameter("gRest"));
        Date gDate = null;
        try {
            gDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Good g = new Good(id,name,gType,location,gDate,gRest);
        gs.goodUpdateService(g);
        resp.sendRedirect(req.getContextPath() + "/list");
    }
}
