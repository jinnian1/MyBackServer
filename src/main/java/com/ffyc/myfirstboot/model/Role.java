package com.ffyc.myfirstboot.model;

import java.sql.Timestamp;
import java.util.List;

public class Role {
    private  Integer id;
    private  String name;
    private  String mark;
    private  Integer operatePerson;
    private Timestamp operateTime;
    private List<Menu>menuList;
    private  String operatePersonString;

    public String getOperatePersonString() {
        return operatePersonString;
    }

    public void setOperatePersonString(String operatePersonString) {
        this.operatePersonString = operatePersonString;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getOperatePerson() {
        return operatePerson;
    }

    public void setOperatePerson(Integer operatePerson) {
        this.operatePerson = operatePerson;
    }

    public Timestamp getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Timestamp operateTime) {
        this.operateTime = operateTime;
    }
}
