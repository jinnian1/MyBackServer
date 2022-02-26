package com.ffyc.myfirstboot.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 宿舍类
 *
 * @author Deevan
 */
@Component
public class Room {
    private Integer id;
    private String number;
    private Integer height;
    private Integer buildingID;
    private String buildingName;
    private Integer operator;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operateTime;
    private Integer pageNum;
    private Integer pageSize;
    private String operatorAccount;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", height=" + height +
                ", buildingID=" + buildingID +
                ", buildingName='" + buildingName + '\'' +
                ", operator=" + operator +
                ", operateTime=" + operateTime +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", operatorAccount='" + operatorAccount + '\'' +
                '}';
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getOperatorAccount() {
        return operatorAccount;
    }

    public void setOperatorAccount(String operatorAccount) {
        this.operatorAccount = operatorAccount;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(Integer buildingID) {
        this.buildingID = buildingID;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
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
}
