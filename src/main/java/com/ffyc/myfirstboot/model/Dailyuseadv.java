package com.ffyc.myfirstboot.model;

public class Dailyuseadv {
    private  Integer id;
    private  Integer type;
    private  Integer state;
    private  String name;
    private   String picture;
    private Integer pageSize;
    private Integer pageNum;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Dailyuseadv{" +
                "id=" + id +
                ", type=" + type +
                ", state=" + state +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                '}';
    }
}
