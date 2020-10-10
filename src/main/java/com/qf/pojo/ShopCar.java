package com.qf.pojo;

import java.util.List;

public class ShopCar {
    private int id;
    private  int uid;
    private int gid;
    private int number=0; //商品数量
    private double money; //共计
    private Goods goods;

    @Override
    public String toString() {
        return "ShopCar{" +
                "id=" + id +
                ", uid=" + uid +
                ", gid=" + gid +
                ", number=" + number +
                ", money=" + money +
                ", goods=" + goods +
                '}';
    }

    public ShopCar(int id, int uid, int gid, int number, double money, Goods goods) {
        this.id = id;
        this.uid = uid;
        this.gid = gid;
        this.number = number;
        this.money = money;
        this.goods = goods;
    }

    public ShopCar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getMoney() {
        String price = goods.getPrice();
        int pc = Integer.parseInt(price);
        return pc*number;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
