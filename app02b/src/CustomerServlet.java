import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = {"/customer","/editCustomer","/updateCustomer"})
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = -20L;

    private List<Customer> customers = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        Customer c1 = new Customer();
        c1.setId(1);
        c1.setName("师东璇");
        c1.setCity("运城");

        Customer c2 = new Customer();
        c2.setId(2);
        c2.setName("张硕");
        c2.setCity("西安");
    }

    private void sendCustomerList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>Customers</title></head>" +
                "<body><h2>Customers</h2>");
        writer.println("</ul>");
        for (Customer customer : customers){
            writer.println("<li>" + customer.getName() + "(" + customer.getCity() + ")" +
                    "(" + "<a href='editCustomer?id=" + customer.getId() + "'>edit</a>)");
        }
        writer.println("</ul>");
        writer.println("</body></html>");
    }

    private Customer getCustomer(int customerId){
        for (Customer customer : customers){
            if (customer.getId() == customerId){
                return customer;
            }
        }
        return null;
    }

    private void sendEditCustomForm(HttpServletRequest req,
                                    HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        int customerId = 0;
        customerId = Integer.parseInt(req.getParameter("id"));
        Customer customer = getCustomer(customerId);

        if (customer != null){
            writer.println("<html><head>" + "<title>Edit Customer</title></head>"
            + "<body><h2>Edit Customer<h2>" + "<form method='post' " + "action='updateCustomer'");
            writer.println("<input type='hidden' name='id' value='" + customerId +"'/>");
            writer.println();
        }
    }
}
