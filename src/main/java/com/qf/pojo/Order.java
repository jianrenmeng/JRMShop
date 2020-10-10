package com.qf.pojo;

import java.util.Date;

public class Order {
    private String oid;
    private String address;//地址中id
    private String time;//时间
    private int statu;//0未支付 1支付
    private double totalmoney;
    private  int gid;
    private Goods goods;//购物车的

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", address='" + address + '\'' +
                ", time='" + time + '\'' +
                ", statu=" + statu +
                ", totalmoney=" + totalmoney +
                ", gid=" + gid +
                ", goods=" + goods +
                '}';
    }

    public Order(String oid, String address, String time, int statu, double totalmoney, int gid, Goods goods) {
        this.oid = oid;
        this.address = address;
        this.time = time;
        this.statu = statu;
        this.totalmoney = totalmoney;
        this.gid = gid;
        this.goods = goods;
    }

    public Order() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
