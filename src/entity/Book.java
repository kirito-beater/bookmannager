package entity;

public class Book {
    private int bid;
    private String bname;
    public Book(){
        super();
    }

    public Book(int bid) {
        super();
        this.bid = bid;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getStoretime() {
        return storetime;
    }

    public void setStoretime(String storetime) {
        this.storetime = storetime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", price='" + price + '\'' +
                ", cid='" + cid + '\'' +
                ", storetime='" + storetime + '\'' +
                '}';
    }

    public Book(int bid, String bname, String price, String cid, String storetime) {
        this.bid = bid;
        this.bname = bname;
        this.price = price;
        this.cid = cid;
        this.storetime = storetime;
    }

    private String price;
    private String cid;
    private String storetime;
}

