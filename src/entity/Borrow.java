package entity;

public class Borrow {

    private static final long serialVersionUID = 1L;

    private String bwid;

    private int bid;

    private String bname;

    private int sid;

    private String sname;

    private String bwdate;

    private String expectdate;

    private String bwstatus;

    public String getBwid() {
        return bwid;
    }


    public void setBwid(String bwid) {
        this.bwid = bwid;
    }


    public int getBid() {
        return bid;
    }


    public void setBid(int bid) {
        this.bid = bid;
    }


    public String getBname() {
        return bname;
    }


    public void setBname(String bname) {
        this.bname = bname;
    }


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


    public String getBwdate() {
        return bwdate;
    }


    public void setBwdate(String bwdate) {
        this.bwdate = bwdate;
    }


    public String getExpectdate() {
        return expectdate;
    }


    public void setExpectdate(String expectdate) {
        this.expectdate = expectdate;
    }


    public String getBwstatus() {
        return bwstatus;
    }


    public void setBwstatus(String bwstatus) {
        this.bwstatus = bwstatus;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    public Borrow(int sid) {
        super();
        this.sid = sid;
    }

    public Borrow(int bid, int sid, String expectdate, String bwstatus) {
        super();
        this.bid = bid;
        this.sid = sid;
        this.expectdate = expectdate;
        this.bwstatus = bwstatus;
    }


    public Borrow(String bwid, int bid, String bname, int sid, String sname, String bwdate, String expectdate,
                  String bwstatus) {
        super();
        this.bwid = bwid;
        this.bid = bid;
        this.bname = bname;
        this.sid = sid;
        this.sname = sname;
        this.bwdate = bwdate;
        this.expectdate = expectdate;
        this.bwstatus = bwstatus;
    }


    public Borrow() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Borrow(int bid, String bname, int sid, String sname, String bwdate, String expectdate,
                  String bwstatus) {
        super();
        this.bid = bid;
        this.bname = bname;
        this.sid = sid;
        this.sname = sname;
        this.bwdate = bwdate;
        this.expectdate = expectdate;
        this.bwstatus = bwstatus;
    }


    @Override
    public String toString() {
        return "Borrow [bwid=" + bwid + ", bid=" + bid + ", bname=" + bname + ", sid=" + sid + ", sname=" + sname
                + ", bwdate=" + bwdate + ", expectdate=" + expectdate + ", bwstatus=" + bwstatus + "]";
    }
}
