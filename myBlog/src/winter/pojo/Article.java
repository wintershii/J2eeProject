package winter.pojo;

import java.util.Date;
import java.sql.*;

public class Article {
    private int id;
    private String title;
    private String author;
    private int aid;
    private Date aDate;
    private String essay;
    private String markdown;
    private int views;

    public Article(int id, String title, String author, int aid, Date aDate, String essay, String markdown, int views) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.aid = aid;
        this.aDate = aDate;
        this.essay = essay;
        this.markdown = markdown;
        this.views = views;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public Article() {
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Date getaDate() {
        return aDate;
    }

    public void setaDate(Date aDate) {
        this.aDate = aDate;
    }

    public String getEssay() {
        return essay;
    }

    public void setEssay(String essay) {
        this.essay = essay;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", aid=" + aid +
                ", aDate=" + aDate +
                ", essay='" + essay + '\'' +
                ", views=" + views +
                '}';
    }
}
