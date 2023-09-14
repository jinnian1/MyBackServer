package com.ffyc.myfirstboot.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * 新闻类
 * @author Deevan
 */

public class News {
    private Integer id;
    private String title;
    private String content;
    private String summary;
    private String info;
    private String picture;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String outputTime;
    private Integer operator;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operateTime;
    private Integer pageNum;
    private Integer pageSize;
    private String operatorAccount;

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", info='" + info + '\'' +
                ", picture='" + picture + '\'' +
                ", outputTime='" + outputTime + '\'' +
                ", operator=" + operator +
                ", operateTime=" + operateTime +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", operatorAccount='" + operatorAccount + '\'' +
                '}';
    }

    public String getOperatorAccount() {
        return operatorAccount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getOutputTime() {
        return outputTime;
    }

    public void setOutputTime(String outputTime) {
        this.outputTime = outputTime;
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
