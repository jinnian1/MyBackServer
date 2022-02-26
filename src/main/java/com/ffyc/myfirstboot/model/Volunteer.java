package com.ffyc.myfirstboot.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 志愿者类
 *
 * @author Deevan
 */
@Component
public class Volunteer {
    private Integer id;
    private Integer studentID;
    private Integer type;
    private String health;
    private Integer state;
    private Integer operator;


    //读
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operateTime;
    private Integer pageNum;
    private Integer pageSize;
    private String operatorAccount;
    private String typeString;
    private String stateString;
    private String studentName;

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    public String getStateString() {
        return stateString;
    }

    public void setStateString(String stateString) {
        this.stateString = stateString;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
