package com.ffyc.myfirstboot.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class Manage {
    private  String token;
    private String account;
    private  String password;
    private  String name;
    private  Integer id;
    private  Integer type;
    private List<Role> roleList;
    private  String phone;
    private  String address;
    private String sex;
    private String typeString;
    private Integer[] roleId;
    private Timestamp operateTime;
    private  Integer pageNum;
    private  Integer pageSize;
    private Date birthday;
    private String password1;  //修改密码时的原密


    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Timestamp getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Timestamp operateTime) {
        this.operateTime = operateTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    public Integer[] getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer[] roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Manage{" +
                "token='" + token + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", newFileName='" + name + '\'' +
                ", id=" + id +
                ", type=" + type +
                ", roleList=" + roleList +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", typeString='" + typeString + '\'' +
                ", roleId=" + Arrays.toString(roleId) +
                ", operateTime=" + operateTime +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", birthday=" + birthday +
                ", password1='" + password1 + '\'' +
                '}';
    }
}
