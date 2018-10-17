package winter.dao;

import winter.pojo.User;
import winter.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserDaoImp implements UserDao {
    static Connection conn = JDBCUtil.getConnection();
    @Override
    public User loginCheckDao(String account, String pwd) {
        String sql = "select * from t_user";
        ResultSet rs = null;
        User u = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    //获取对象信息
                    u = new User();
                    u.setId(rs.getInt("id"));
                    u.setAccount(rs.getString("account"));
                    u.setName(rs.getString("name"));
                    u.setSex(rs.getInt("sex"));
                    try {
                        u.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("birth")));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    u.setSignature(rs.getString("signature"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public void registerDao(String account, String pwd, String name, int sex, String birth, String signature) {
        String sql = "insert into t_user (id,account,pwd,name,sex,birth,signature) values (default,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,account);
            ps.setString(2,pwd);
            ps.setString(3,name);
            ps.setInt(4,sex);
            ps.setString(5,birth);
            ps.setString(6,signature);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
