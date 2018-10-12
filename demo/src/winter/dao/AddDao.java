package winter.dao;

import winter.poju.Student;
import winter.util.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class AddDao {
    public void addDao(Student student){
        Connection conn = JDBCUtil.getConnection();
        String sql = "insert into t_stu (uname,pwd,class,name,entryDate) values (?,?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,student.getUname());
            ps.setString(2,student.getPwd());
            ps.setString(3,student.getClassnum());
            ps.setString(4,student.getName());
            ps.setString(5, sdf.format(student.getEntryDate()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
