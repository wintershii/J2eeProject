package winter.dao;

import winter.poju.Student;
import winter.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCheckDaoImp implements LoginCheckDao{
    @Override
    public Student loginCheckDao(String uname, String pwd) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from t_stu where uname = ? and pwd = ?";
        ResultSet rs = null;
        Student student = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,pwd);
            rs = ps.executeQuery();
            while (rs.next()){
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setUname(rs.getString("uname"));
                student.setName(rs.getString("name"));
                student.setClassnum(rs.getString("class"));
                student.setEntryDate(rs.getDate("entryDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
