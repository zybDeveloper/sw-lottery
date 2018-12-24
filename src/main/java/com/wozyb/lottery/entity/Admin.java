package com.wozyb.lottery.entity;


/*
* 管理员类
* */
public class Admin {
    //编号
    private int id;
    //用户名
    private String username;
    //密码
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
