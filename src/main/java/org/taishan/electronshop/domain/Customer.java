package org.taishan.electronshop.domain;

import java.util.*;

/**
 * 客户类
 */
public class Customer {

    /**  对象标识符(对应数据库主键) */
    private Integer id;
    /**  登录名称  */
    private String username;
    /** 登录密码  */
    private String password;
    /**  客户姓名 */
    private String name;
    /**  性别 */
    private String gender;
    /** 出生日期  */
    private Date birthdate;
    /** 电话号码 */
    private String telephone;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}