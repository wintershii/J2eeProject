import poju.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "book",urlPatterns = {"/book"})
public class BookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> list = new ArrayList<>();
        Book b1 = new Book("Java从入门到放弃","师东璇",new Date(1999,7,8));
        Book b2 = new Book("数据结构坟墓","师东璇",new Date(2017,7,1));
        Book b3 = new Book("算法不美","师东璇",new Date(2018,6,6));

        list.add(b1);
        list.add(b2);
        list.add(b3);

        req.setAttribute("books",list);

        Map<String,String[]> map = new HashMap<>();
        map.put("China",new String[] {"西安","北京","上海"});
        map.put("USA",new String[] {"纽约","LA","西雅图"});
        map.put("Japan",new String[] {"东京","大阪","名古屋"});

        req.setAttribute("bitCities",map);


        req.getRequestDispatcher("/books.jsp").forward(req,resp);
    }
}
