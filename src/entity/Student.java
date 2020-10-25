package entity;

public class Student {

    private static final long serialVersionUID = 1L;

    private int sid;

    private String sname;

    private String classes;

    private long tells;


    public int getSid() {
        return sid;
    }


    public void setSid(int sid) {
        this.sid = sid;
    }


    public String getSname() {
        return sname;
    }


    public void setSname(String sname) {
        this.sname = sname;
    }


    public String getClasses() {
        return classes;
    }


    public void setClasses(String classes) {
        this.classes = classes;
    }


    public long getTells() {
        return tells;
    }


    public void setTells(long tells) {
        this.tells = tells;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    public Student(int sid, String sname, String classes, long tells) {
        super();
        this.sid = sid;
        this.sname = sname;
        this.classes = classes;
        this.tells = tells;
    }


    public Student() {
        super();

    }


    public Student(String sname, String classes, long tells) {
        super();
        this.sname = sname;
        this.classes = classes;
        this.tells = tells;
    }


    public Student(int sid) {
        super();
        this.sid = sid;
    }


    public Student(int sid, long tells) {
        super();
        this.sid = sid;
        this.tells = tells;
    }


    @Override
    public String toString() {
        return "Student [sid=" + sid + ", sname=" + sname + ", classes=" + classes + ", tells=" + tells + "]";
    }

}
