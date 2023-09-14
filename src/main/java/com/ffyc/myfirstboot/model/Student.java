package com.ffyc.myfirstboot.model;

public class Student {
    private Integer id;
    private String name;
    private String password;
    private  String password1; //修改密码时的原密码
    private  String sno;
    private String phone;
    private  String sex;
    private String sclass;
    private String email;
    private  String icon;
    private  String college;
    private String buildingName;
    private  Integer number;
    private Integer roomId;
    private Integer pageNum;
    private Integer pageSize;
    private  Integer buildingId;
    private  Integer height;
    private Integer verifycode;
    private float residueElectric;



    public float getResidueElectric() {
        return residueElectric;
    }

    public void setResidueElectric(float residueElectric) {
        this.residueElectric = residueElectric;
    }

    public Integer getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(Integer verifycode) {
        this.verifycode = verifycode;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public Integer getroomId() {
        return roomId;
    }

    public void setroomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", password1='" + password1 + '\'' +
                ", sno='" + sno + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", sclass='" + sclass + '\'' +
                ", email='" + email + '\'' +
                ", icon='" + icon + '\'' +
                ", college='" + college + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", number=" + number +
                ", roomId=" + roomId +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", buildingID=" + buildingId +
                ", height=" + height +
                ", verifycode=" + verifycode +
                '}';
    }
}
