package com.qf.pojo;

/**
 * 地址实体类
 */
public class Address {
    private int  aid;
    private String aname;
    private String aemail;
    private String telphone;
    private String city;
    private  String detailaddress;
    private int uid;

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", aemail='" + aemail + '\'' +
                ", telphone='" + telphone + '\'' +
                ", city='" + city + '\'' +
                ", detailaddress='" + detailaddress + '\'' +
                ", uid=" + uid +
                '}';
    }

    public Address(int aid, String aname, String aemail, String telphone, String city, String detailaddress, int uid) {
        this.aid = aid;
        this.aname = aname;
        this.aemail = aemail;
        this.telphone = telphone;
        this.city = city;
        this.detailaddress = detailaddress;
        this.uid = uid;
    }

    public Address() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAemail() {
        return aemail;
    }

    public void setAemail(String aemail) {
        this.aemail = aemail;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetailaddress() {
        return detailaddress;
    }

    public void setDetailaddress(String detailaddress) {
        this.detailaddress = detailaddress;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
