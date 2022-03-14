package com.ffyc.myfirstboot.model;

import java.util.Date;

public class Food {
    private  Integer id;
    private Integer studentID;
    private  Integer state;
    private  String name;
    private  String buildingName;
    private  Integer number;
    private  String restaurant;
    private  String foodname;
    private  String remark;
    private String foodfile;
    private Date time;
    private String type;
    private  String  repper;
    private Integer pageNum;
    private String rest;
    private String repperString;

    public String getRepperString() {
        return repperString;
    }

    public void setRepperString(String repperString) {
        this.repperString = repperString;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFoodfile() {
        return foodfile;
    }

    public void setFoodfile(String foodfile) {
        this.foodfile = foodfile;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }



    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    private Integer pageSize;
    private Integer data;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
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

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRepper() {
        return repper;
    }

    public void setRepper(String repper) {
        this.repper = repper;
    }


    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", state=" + state +
                ", name='" + name + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", number=" + number +
                ", restaurant='" + restaurant + '\'' +
                ", foodname='" + foodname + '\'' +
                ", remark='" + remark + '\'' +
                ", time=" + time +
                ", repper=" + repper +
                ", pageNum=" + pageNum +
                ", studentID=" + studentID +
                ", pageSize=" + pageSize +
                ", data=" + data +
                '}';
    }
}
