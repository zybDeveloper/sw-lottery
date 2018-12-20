package com.wozyb.lottery.entity;

/**
 * Created by zyb on 18-12-12.
 */
public class User {
    //id number
    private int id;
    //用户名
    private String name;
    //手机号
    private String phone;
    //工号
    private String number;
    //头像
    private String image;
    //中奖标识
    private String isVail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsVail() {
        return isVail;
    }

    public void setIsVail(String isVail) {
        this.isVail = isVail;
    }

    @Override
    public String toString(){
        return  "user:"+id+name+phone+number+image+isVail;
    }
}
