package dao.impl;

import dao.JDBCUtil;
import dao.LoginDao;
import pojo.User;

import java.sql.*;

public class LoginDaoImpl implements LoginDao {

    @Override
    public User chechLoginDao(String uname, String pwd) {
        //声明JDBC对象
        Connection conn;
        PreparedStatement ps = null;
        //声明数据存储对象
        User u = null;

        try {
            conn = JDBCUtil.getConnection();
            //创建sql命令
            String sql = "select * from t_user where uname=? and pwd=?";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1,uname);
            ps.setString(2,pwd);
            //执行sql
            ResultSet rs = ps.executeQuery();
            //遍历执行结果
            while (rs.next()){
                u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
            }
            return u;
            //关闭资源
            //返回

        }  catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return null;
    }
}
