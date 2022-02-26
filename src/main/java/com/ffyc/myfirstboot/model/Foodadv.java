package com.ffyc.myfirstboot.model;

public class Foodadv {
    private  Integer id;
    private  Integer position;
    private  String file;
    private  Integer type;
    private Integer pageNum;
    private Integer filenum;

    public Integer getFilenum() {
        return filenum;
    }

    public void setFilenum(Integer filenum) {
        this.filenum = filenum;
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Foodadv{" +
                "id=" + id +
                ", position=" + position +
                ", file='" + file + '\'' +
                ", type=" + type +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
