package winter.dao;

import winter.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteDao {
    public void deleteDao(int id){
        Connection conn = JDBCUtil.getConnection();
        String sql = "delete from t_stu where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
