package com.ffyc.myfirstboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Electricity {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;
    private Integer height;
    private String billAmount;
    private String build;
    private String room;
    private String name;
    private Integer state;
    private Integer roomId;
    private Integer buildingId;
    private Integer studentId;
    private float residueElectric;
    private float aggregateAmount;

    public float getResidueElectric() {
        return residueElectric;
    }

    public void setResidueElectric(float residueElectric) {
        this.residueElectric = residueElectric;
    }

    public float getAggregateAmount() {
        return aggregateAmount;
    }

    public void setAggregateAmount(float aggregateAmount) {
        this.aggregateAmount = aggregateAmount;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Electricity{" +
                "id=" + id +
                ", date=" + date +
                ", height=" + height +
                ", billAmount='" + billAmount + '\'' +
                ", build='" + build + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}
