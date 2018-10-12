package winter.poju;

import java.util.Date;

public class Student {
    private int id;
    private String uname;
    private String pwd;
    private String name;
    private String classnum;
    private Date entryDate;

    public Student() {
    }

    public Student(String uname, String pwd, String name, String classnum, Date entryDate) {
        this.uname = uname;
        this.pwd = pwd;
        this.name = name;
        this.classnum = classnum;
        this.entryDate = entryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String num) {
        this.uname = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "num='" + uname + '\'' +
                ", name='" + name + '\'' +
                ", classnum='" + classnum + '\'' +
                ", entryDate=" + entryDate +
                '}';
    }
}
