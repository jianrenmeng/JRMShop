package com.qf.pojo;

public class WishList {
    private int id;
    private int gid;
    private int price;
    private String gname;
   private String normalpic;

    @Override
    public String toString() {
        return "WishList{" +
                "id=" + id +
                ", gid=" + gid +
                ", price=" + price +
                ", gname='" + gname + '\'' +
                ", normalpic='" + normalpic + '\'' +
                '}';
    }

    public WishList(int id, int gid, int price, String gname, String normalpic) {
        this.id = id;
        this.gid = gid;
        this.price = price;
        this.gname = gname;
        this.normalpic = normalpic;
    }

    public WishList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getNormalpic() {
        return normalpic;
    }

    public void setNormalpic(String normalpic) {
        this.normalpic = normalpic;
    }
}
