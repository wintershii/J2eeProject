import poju.Adress;
import poju.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "employee",urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Adress adress = new Adress();
        adress.setStreetName("长安街");
        adress.setStreetNumber("168");
        adress.setCity("Xian");
        adress.setCountry("China");

        Employee employee = new Employee();
        employee.setId(6);
        employee.setName("师东璇");
        employee.setAdress(adress);

        req.setAttribute("employee",employee);

        Map<String,String> map = new HashMap<>();
        map.put("China","Beijing");
        map.put("Austria","Vienna");
        map.put("Australia","Canberra");
        map.put("Canada","Ottawa");
        req.setAttribute("capitals",map);

        HttpSession hs = req.getSession();
        hs.setAttribute("what","fuck");

        Cookie cookie = new Cookie("cookie","shi");
        resp.addCookie(cookie);

        req.getRequestDispatcher("/employee.jsp").forward(req,resp);
    }
}

