package winter.dao;

import winter.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateDao {
    public void updateDao(int id, String name, String classnum, Date entryDate){
        Connection conn = JDBCUtil.getConnection();
        String sql = "update t_stu set (name,class,date) values (?,?,?) where id = ?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,classnum);
            ps.setString(3,sdf.format(entryDate));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
