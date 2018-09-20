package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class NumServlet extends HttpServlet {
    //覆写Init方法，将数据读取到ServletContext对象中
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //获取文件中的计数器数据
            //获取文件路径
            String path=this.getServletContext().getRealPath("/doc/num.txt");

        //this.getServletContext().getResourceAsStream("/doc/num.txt");
        //声明流对象
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            int num = br.read();
            System.out.println(num + " ");
            this.getServletContext().setAttribute("nums",num);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //覆写销毁方法，存储计数器到文件中
    @Override
    public void destroy() {
        //获取网页计数器
        int num = (int) this.getServletContext().getAttribute("nums");
        //获取文件路径
        String path = this.getServletContext().getRealPath("/doc/num.txt");

        //声明流对象
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw=new FileWriter(path);
            bw=new BufferedWriter(fw);
            bw.write(num);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(1);
    }
}
