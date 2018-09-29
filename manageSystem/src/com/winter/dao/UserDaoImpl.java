package com.winter.dao;

import com.winter.jdbcutil.JDBCUtil;
import com.winter.poju.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    //根据用户名和密码进行查询
    @Override
    public User checkUserLoginDao(String uname, String pwd) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        //获取连接
        Connection conn = JDBCUtil.getConnection();
        //创建sql命令
        String sql = "select * from t_user where uname=? and pwd=?";
        try {
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1,uname);
            ps.setString(2,pwd);
            //执行sql
            rs = ps.executeQuery();
            //遍历结果
            while (rs.next()){
                //给变量赋值
                User u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setSex(rs.getString("sex"));
                u.setAge(rs.getInt("age"));
                u.setBirth(rs.getString("birth"));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //根据用户id修改用户密码
    @Override
    public void userChangePwdDao(String newPwd, int uid) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "update t_user set pwd = ? where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,newPwd);
            ps.setInt(2,uid);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
