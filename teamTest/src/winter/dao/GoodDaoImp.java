package winter.dao;

import winter.Util.JDBCUtil;
import winter.poju.Good;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GoodDaoImp implements GoodDao{
    @Override
    public List<Good> listGetDao() {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from t_good";
        ResultSet rs = null;
        List<Good> list = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                list = new ArrayList<>();
                while (rs.next()) {
                    Good g = getGood(rs);
                    list.add(g);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void goodAddDao(Good g) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "insert into t_good (id,name,gType,location,gDate,gRest) values (default ,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,g.getName());
            ps.setString(2,g.getgType());
            ps.setString(3,g.getLocation());
            ps.setString(4,new SimpleDateFormat("yyyy-MM-dd").format(g.getgDate()));
            ps.setInt(5,g.getgRest());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goodDeleteDao(int id) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "delete from t_good where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Good goodGetDao(int id) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from t_good where id = ?";
        ResultSet rs = null;
        Good g = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                g = new Good();
                g.setId(rs.getInt("id"));
                g.setName(rs.getString("name"));
                g.setgType(rs.getString("gType"));
                g.setLocation(rs.getString("location"));
                g.setgDate(rs.getDate("gDate"));
                g.setgRest(rs.getInt("gRest"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return g;
    }

    @Override
    public void goodUpdateDao(Good g) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "update t_good set name = ?,gType = ?,location = ?,gDate = ?,gRest = ? where id = ?";

        int id = g.getId();
        String name = g.getName();
        String gType = g.getgType();
        String location = g.getLocation();
        String gDate = new SimpleDateFormat("yyyy-MM-dd").format(g.getgDate());
        int gRest = g.getgRest();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,gType);
            ps.setString(3,location);
            ps.setString(4,gDate);
            ps.setInt(5,gRest);
            ps.setInt(6,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Good> goodSearchDao(String info) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from t_good where name = ? or gType = ? or location = ?";
        List<Good> list = null;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,info);
            ps.setString(2,info);
            ps.setString(3,info);
            rs = ps.executeQuery();
            if (rs != null){
                list = new ArrayList<>();
                while (rs.next()){
                    Good g = getGood(rs);
                    list.add(g);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Good getGood(ResultSet rs){
            Good g = new Good();
        try {
            g.setId(rs.getInt("id"));
            g.setName(rs.getString("name"));
            g.setgType(rs.getString("gType"));
            g.setLocation(rs.getString("location"));
            g.setgDate(rs.getDate("gDate"));
            g.setgRest(rs.getInt("gRest"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return g;
    }
}
