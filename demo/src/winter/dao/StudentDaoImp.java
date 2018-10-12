package winter.dao;

import winter.poju.Student;
import winter.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDaoImp implements StudentDao{
    static Connection conn = JDBCUtil.getConnection();
    @Override
    public Student loginCheckDao(String uname, String pwd) {
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

    @Override
    public void addDao(Student student) {
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

    @Override
    public void deleteDao(int id) {
        String sql = "delete from t_stu where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> listGetDao() {
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

    @Override
    public Student studentGetDao(int id) {
        String sql = "select * from t_stu where id = ?";
        ResultSet rs = null;
        Student student = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                student = new Student();
                student.setId(id);
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

    @Override
    public void updateDao(int id, String name, String classnum, Date entryDate) {
        String sql = "update t_stu set name = ?,class = ?,entryDate = ? where id = ?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,classnum);
            ps.setString(3,sdf.format(entryDate));
            ps.setInt(4,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
