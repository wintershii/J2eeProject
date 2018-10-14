package winter.poju;

import java.util.Date;

public class Good {
    private int id;
    private String name;
    private String gType;
    private String location;
    private Date gDate;
    private int gRest;

    public Good() {
    }

    public Good(int id, String name, String gType, String location, Date gDate, int gRest) {
        this.id = id;
        this.name = name;
        this.gType = gType;
        this.location = location;
        this.gDate = gDate;
        this.gRest = gRest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getgDate() {
        return gDate;
    }

    public void setgDate(Date gDate) {
        this.gDate = gDate;
    }

    public int getgRest() {
        return gRest;
    }

    public void setgRest(int gRest) {
        this.gRest = gRest;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gType='" + gType + '\'' +
                ", location='" + location + '\'' +
                ", gDate=" + gDate +
                ", gRest=" + gRest +
                '}';
    }
}
