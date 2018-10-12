package winter.dao;

import winter.poju.Student;
import winter.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListGetDao {
    public List<Student> listGetDao(){
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from t_stu";
        ResultSet rs = null;
        List<Student> list = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                list = new ArrayList<>();

                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setUname(rs.getString("uname"));
                    student.setName(rs.getString("name"));
                    student.setClassnum(rs.getString("class"));
                    student.setEntryDate(rs.getDate("entryDate"));
                    list.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
