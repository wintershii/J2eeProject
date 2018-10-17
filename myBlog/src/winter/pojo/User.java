package winter.pojo;

import java.util.Date;

public class User {
    private int id;
    private String account;
    private String pwd;
    private String name;
    private int sex;
    private Date birth;
    private String signature;


    public User(int id, String account, String pwd, String name, int sex, Date birth, String signature) {
        this.id = id;
        this.account = account;
        this.pwd = pwd;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.signature = signature;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", signature='" + signature + '\'' +
                '}';
    }
}
