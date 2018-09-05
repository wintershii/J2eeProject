import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Top10Servlet",urlPatterns = {"/top10"})
public class Top10Servlet extends HttpServlet {
    private static final long serialVersionUID = 987654321L;

    private List<String> londonAttractions;
    private List<String> praisAttractions;

    @Override
    public void init() throws ServletException {
        londonAttractions = new ArrayList<>();
        londonAttractions.add("1");
        londonAttractions.add("2");
        londonAttractions.add("3");
        londonAttractions.add("4");
        londonAttractions.add("5");
        londonAttractions.add("6");
        londonAttractions.add("7");
        londonAttractions.add("8");
        londonAttractions.add("9");
        londonAttractions.add("0");

        praisAttractions = new ArrayList<>();
        praisAttractions.add("a");
        praisAttractions.add("b");
        praisAttractions.add("c");
        praisAttractions.add("d");
        praisAttractions.add("e");
        praisAttractions.add("f");
        praisAttractions.add("g");
        praisAttractions.add("h");
        praisAttractions.add("i");
        praisAttractions.add("j");
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        String city  = req.getParameter("city");
        if (city != null && (city.equals("london") || city.equals("paris"))) {
            //show attractions
            showAttractions(req, resp, city);
        } else {
            //show main page
            showMainPage(req,resp);
        }
    }

    private void showMainPage(HttpServletRequest req,
                                 HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<html><head>" +
                "<title>Top 10 Tourist Attractions</title>" +
                "</head><body>" +
                "Please select a city" +
                "<br/><a href='?city=london'>London</a>" +
                "<br/><a href='?city=paris'>Paris</a>" +
                "</body></html>");
    }

    private void showAttractions(HttpServletRequest req,
                                 HttpServletResponse resp, String city) throws IOException {
        int page = 1;
        String pageParameter = req.getParameter("page");
        if (pageParameter != null){
            try{
                page = Integer.parseInt(pageParameter);
            } catch (NumberFormatException e){

            }
            if (page > 2){
                page = 1;
            }
        }
        List<String> attractions = null;
        if (city.equals("london")){
            attractions = londonAttractions;
        } else if (city.equals("paris")){
            attractions = praisAttractions;
        }
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head>" + "<title>Top 10 Tourist Attractions</title>" +
                "</head><body>");
        writer.println("<a href='top10'>Select City</a>");
        writer.println("<hr/>Page" + page + "<hr/>");
        int start = page *5 - 5;
        for (int i = start; i < start + 5; i++){
            writer.println(attractions.get(i) + "<br/>");
        }
        writer.print("<hr style='color:blue'/>" +
                "<a href='?city=" + city + "&page=1'>Page 1</a>");
        writer.println("&nbsp; <a href='?city=" + city + "&page=2'>Page 2</a>");
        writer.println("</body><html>");
    }
}
