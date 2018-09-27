package com.winter.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection(){
        //声明jdbc对象
        Connection conn = null;
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?useSSL=false&" +
                    "serverTimezone=GMT%2B8&characterEncoding=utf-8","root","990708");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //获取连接
        return conn;
    }
}
