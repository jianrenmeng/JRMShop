package com.qf.pojo;

public class User {
    private int uid;
    private String username;//用户名
    private String realname;//真实姓名
    private String gender;//性别
    private String telphone;//电话
    private String email;//邮箱
    private String password;
    private int flag;//是否激活 Y激活 N未激活
    private String code; // 激活码

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", gender='" + gender + '\'' +
                ", telphone='" + telphone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", flag=" + flag +
                ", code='" + code + '\'' +
                '}';
    }

    public User(int uid, String username, String realname, String gender, String telphone, String email, String password, int flag, String code) {
        this.uid = uid;
        this.username = username;
        this.realname = realname;
        this.gender = gender;
        this.telphone = telphone;
        this.email = email;
        this.password = password;
        this.flag = flag;
        this.code = code;
    }

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
