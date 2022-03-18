package com.ffyc.myfirstboot.controller;


import com.ffyc.myfirstboot.model.Dailyuseadv;
import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.service.Dailyuseadvservice;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Dailyuseadvcontroller {
    @Autowired
    Dailyuseadvservice dailyuseadvservice;

    @RequestMapping(value ="/dailyuseadv")
    public CommonResult dailyuseadv() {
        try {
            List<Dailyuseadv> dayiluseadvs= dailyuseadvservice.select();
            return new CommonResult(200, "查找成功",dayiluseadvs);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败", (Manage) null);
        }
    }
    @RequestMapping(value ="/dailyuseadv1")
    public CommonResult dailyuseadv1() {
        try {
            List<Dailyuseadv> dayiluseadvs= dailyuseadvservice.select1();
            return new CommonResult(200, "查找成功",dayiluseadvs);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败", (Manage) null);
        }
    }
    @RequestMapping(value ="/dailyuseadv2")
    public CommonResult dailyuseadv2() {
        try {
            List<Dailyuseadv> dayiluseadvs= dailyuseadvservice.select2();
            return new CommonResult(200, "查找成功",dayiluseadvs);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败", (Manage) null);
        }
    }
    @RequestMapping(value ="/dailyuseadv3")
    public CommonResult dailyuseadv3() {
        try {
            List<Dailyuseadv> dayiluseadvs= dailyuseadvservice.select3();
            return new CommonResult(200, "查找成功",dayiluseadvs);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败", (Manage) null);
        }
    }
    @RequestMapping(value ="/dailyuseadv4")
    public CommonResult dailyuseadv4() {
        try {
            List<Dailyuseadv> dayiluseadvs= dailyuseadvservice.select4();
            return new CommonResult(200, "查找成功",dayiluseadvs);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败", (Manage) null);
        }
    }

    @RequestMapping(value ="/backdailyuseadv")
    public CommonResult backdailyuseadv(@RequestBody Dailyuseadv dailyuseadv){
        try {
            PageInfo<Dailyuseadv> dailyuseadvs=dailyuseadvservice.Backdailyuseadv(dailyuseadv);
            return new CommonResult(200, "查找成功",dailyuseadvs.getList(),dailyuseadvs.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    @RequestMapping(value ="/adddailyuseadv")
    public CommonResult adddailyuseadv(@RequestBody Dailyuseadv dailyuseadv) {
        dailyuseadv.setPicture(StringUtil.subFileType1(dailyuseadv.getPicture()));
        try {
             dailyuseadvservice.adddailyuseadv(dailyuseadv);
            return new CommonResult(200, "添加成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "添加失败", (Manage) null);
        }
    }


    @RequestMapping(value ="/updatedailid/{id}")
    public CommonResult updatedailid(@PathVariable("id") Integer id){

        try {
            Dailyuseadv dailyuseadv=dailyuseadvservice.updatedailid(id);
            return new CommonResult(200, "更新成功",dailyuseadv);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "更新失败",  null);
        }
    }

    @RequestMapping(value ="/updatedail")
    public CommonResult updatedail(@RequestBody Dailyuseadv dailyuseadv){
        dailyuseadv.setPicture(StringUtil.subFileType1(dailyuseadv.getPicture()));
        try {
            dailyuseadvservice.updatedail(dailyuseadv);
            return new CommonResult(200, "更新成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "更新失败",  null);
        }
    }



    @RequestMapping(value ="/deletedailyuseadv/{id}")
    public CommonResult delectfood(@PathVariable("id") Integer id){

        try {
            dailyuseadvservice.deletedailyuseadv(id);
            return new CommonResult(200, "删除成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "删除失败",  null);
        }
    }



    @RequestMapping(value ="uppicture")
    public CommonResult<String> uppicture(@RequestParam("adminFile") CommonsMultipartFile adminFile) {
        CommonResult<String> commonResult = null;
        File folder = new File("/usr/local/apache-tomcat-9.0.37/webapps/ROOT/EPC/dailyuse");
        if (!folder.exists()) {
            boolean mkdir = folder.mkdir();
        }
        //生成新文件
        String oldFileName = adminFile.getOriginalFilename();
        String newFileName = StringUtil.newFileName(oldFileName);
        File file = new File(folder, newFileName);
        try {
            //只上传问价,不存数据库
            adminFile.transferTo(file);
            String imgUrl = "http://124.222.0.129:8080/EPC/dailyuse/" + newFileName;
            //String imgUrl = "http://192.168.32.128:8000/springboot/admin/" + adminId + "/" + newFileName;
            commonResult = new CommonResult<>(200, "上传成功,保存后更换", imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "上传失败，服务器忙", null);
        }
        return commonResult;
    }
}