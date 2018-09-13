package dao;

import java.sql.*;

/**
 *  JDBC的工具类 包含获取connection与关闭资源方法
 */
public class JDBCUtil {
    /**
     * 获取 manageSystem 数据库下的connection资源
     * @return conn
     */
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?useSSL=false&" +
                    "serverTimezone=GMT%2B8&characterEncoding=utf-8","root","990708");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Mysql导包失败");
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
            return null;
        }
    }

    public static void close(ResultSet rs, Statement ps, Connection conn){
        try {
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement ps, Connection conn){
        try {
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

