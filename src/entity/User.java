package entity;

public class User {
    private int uid;
    private String account;
    private String password;
    private  String realname;
    private String  personid;
    private  String tell;
    private String address;
    private int power;
    private  String status;
public User(){
    super();
}

    public User(int uid, String account, String password, String realname, String personid, String tell, String address, int power, String status) {
        this.uid = uid;
        this.account = account;
        this.password = password;
        this.realname = realname;
        this.personid = personid;
        this.tell = tell;
        this.address = address;
        this.power = power;
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", account='" + account + '\'' +
                ", password=" + password +
                ", realname='" + realname + '\'' +
                ", personid='" + personid + '\'' +
                ", tell='" + tell + '\'' +
                ", address='" + address + '\'' +
                ", power=" + power +
                ", status='" + status + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
