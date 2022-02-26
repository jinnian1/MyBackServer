package com.ffyc.myfirstboot.model;

import java.sql.Timestamp;
import java.util.Date;

public class Psychologist {
    private String name;
    private String picture;
    private Timestamp starttime;
    private Timestamp endtime;
    private String introduction;
    private  Integer pageNum;
    private  Integer pageSize;

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

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
