package com.qf.pojo;

import java.util.List;

public class Wish {
    private  int id;
    private int uid;
    private int gid;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "id=" + id +
                ", uid=" + uid +
                ", gid=" + gid +
                '}';
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

    public Wish() {
    }

    public Wish(int id, int uid, int gid) {
        this.id = id;
        this.uid = uid;
        this.gid = gid;
    }
}
