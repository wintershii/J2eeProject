package winter.dao;

import winter.pojo.Article;
import winter.pojo.ArticleDescribe;
import winter.pojo.User;
import winter.util.DaoUtil;
import winter.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DaoImp implements ArticleDao,UserDao{
    @Override
    public void articleSubmitDao(Article article) {
        String sql = "insert into t_article (id,title,author,aid,aDate,essay,markdown,views) values (default,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,article.getTitle());
            ps.setString(2,article.getAuthor());
            ps.setInt(3,article.getAid());
            ps.setString(4,new SimpleDateFormat("yyyy-MM-dd").format(article.getaDate()));
            ps.setString(5,article.getEssay());
            ps.setString(6,article.getMarkdown());
            ps.setInt(7,article.getViews());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,ps,null);
        }

        String sql2 = "select id from t_article where title = ? and author = ? and aid = ?";
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql2);
            ps.setString(1,article.getTitle());
            ps.setString(2,article.getAuthor());
            ps.setInt(3,article.getAid());
            rs = ps.executeQuery();
            int id;
            while (rs.next()){
                id = rs.getInt("id");
                articleDescribeDao(id,article);
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,ps,rs);
        }
    }

    @Override
    public List<ArticleDescribe> articleListGetDao(int id) {
        String sql = null;
        if (id == 0){
            sql = "select * from t_artiDescribe";
        } else {
            sql = "select * from t_artiDescribe where aid = ?";
        }
        List<ArticleDescribe> list = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            if (id == 0){
                rs = ps.executeQuery();
            } else {
                ps.setInt(1,id);
                rs = ps.executeQuery();
            }
            if (rs != null){
                list = new ArrayList<>();
                while (rs.next()){
                    ArticleDescribe ad = new ArticleDescribe();
                    ad.setId(rs.getInt("id"));
                    ad.setTitle(rs.getString("title"));
                    ad.setAuthor(rs.getString("author"));
                    ad.setAid(rs.getInt("aid"));
                    try {
                        ad.setaDate(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("aDate")));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    ad.setEssay(rs.getString("essay"));
                    ad.setViews(rs.getInt("views"));
                    list.add(ad);
                }
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,ps,rs);
        }
        return list;
    }

    @Override
    public Article articleGetDao(int id) {
        String sql = "select * from t_article where id = ?";
        String sql2 = "update t_article set views = ? where id = ?";
        String sql3 = "update t_artiDescribe set views = ? where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Article article = null;
        try {
            conn = JDBCUtil.getConnection();
            rs = null;
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            int views = 0;
            while (rs.next()){
                article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setAuthor(rs.getString("author"));
                article.setAid(rs.getInt("aid"));
                article.setEssay(rs.getString("essay"));
                try {
                    article.setaDate(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("aDate")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                views = rs.getInt("views");
                article.setViews(views);
            }
            views++;
            ps = conn.prepareStatement(sql2);
            ps.setInt(1,views);
            ps.setInt(2,id);
            ps.executeUpdate();
            ps = conn.prepareStatement(sql3);
            ps.setInt(1,views);
            ps.setInt(2,id);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,ps,rs);
        }
        return article;
    }

    @Override
    public void articleDeleteDao(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from t_article where id = ?";
        String sql2 = "delete from t_artiDescribe where id = ?";
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps = conn.prepareStatement(sql2);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Article markdownGetDao(int id) {
        String sql = "select markdown,title from t_article where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String markdown = null;
        String title = null;
        Article a = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                a = new Article();
                markdown = rs.getString("markdown");
                title = rs.getString("title");
                a.setTitle(title);
                a.setMarkdown(markdown);
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public void articleUpdateDao(int id, String title,String markdown, String essay) {
        String sql = "update t_article set title = ?,markdown = ?,essay = ? where id = ?";
        String sql2 = "update t_artiDescribe set title = ?,essay = ? where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,title);
            ps.setString(2,markdown);
            ps.setString(3,essay);
            ps.setInt(4,id);
            ps.executeUpdate();
            String describe = DaoUtil.delHTMLTag(essay);
            ps = conn.prepareStatement(sql2);
            ps.setString(1,title);
            ps.setString(2,describe);
            ps.setInt(3,id);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void articleDescribeDao(int id,Article article){
        String sql = "insert into t_artiDescribe (id,title,author,aid,aDate,essay,views) values (?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,article.getTitle());
            ps.setString(3,article.getAuthor());
            ps.setInt(4,article.getAid());
            ps.setString(5,new SimpleDateFormat("yyyy-MM-dd").format(article.getaDate()));
            ps.setString(6, DaoUtil.delHTMLTag(article.getEssay()));
            ps.setInt(7,article.getViews());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,ps,null);
        }
    }

    @Override
    public User loginCheckDao(String account, String pwd) {
        String sql = "select * from t_user where account = ? and pwd = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,account);
            ps.setString(2,pwd);
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
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,ps,rs);
        }
        return u;
    }

    @Override
    public void registerDao(String account, String pwd, String name, int sex, String birth, String signature) {
        String sql = "insert into t_user (id,account,pwd,name,sex,birth,signature) values (default,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,account);
            ps.setString(2,pwd);
            ps.setString(3,name);
            ps.setInt(4,sex);
            ps.setString(5,birth);
            ps.setString(6,signature);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,ps,null);
        }
    }

    @Override
    public void userUpdateDao(String name, int sex, String birth, String signature,int id) {
        String sql = "update t_user set name = ?,sex = ?,birth = ?,signature = ? where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setInt(2,sex);
            ps.setString(3,birth);
            ps.setString(4,signature);
            ps.setInt(5,id);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,ps,null);
        }
    }

    @Override
    public User userGetDao(int id) {
        String sql = "select * from t_user where id = ?";
        User u = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            rs = null;
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    u = new User();
                    u.setId(rs.getInt("id"));
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
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn,ps,rs);
        }
        return u;
    }
}
