package com.example.jian.mvvm.model.bean;

import java.io.Serializable;

/**
 * @Author: JianTours
 * @Data: 2022/4/6 22:16
 * @Description:
 */
public class UserBean implements Serializable {
    private String phone;
    private String password;
    private String name;
    private String sex;
    private String address;
    private String organization;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
