package winter.dao;

import winter.poju.Student;
import winter.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentGetDao {
    public Student studentGetDao(int id){
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from t_stu where id = ?";
        ResultSet rs = null;
        Student student = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
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
