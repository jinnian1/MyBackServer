package com.ffyc.myfirstboot.controller;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.ffyc.myfirstboot.model.Dailyuseadv;
import com.ffyc.myfirstboot.model.Foodadv;
import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.service.Foodadvservice;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Foodadvcontroller {
    @Autowired
    Foodadvservice foodadvservice;

    @RequestMapping(value ="/foodadv")
    public CommonResult Foodadv(@RequestBody Foodadv foodadv){
        System.out.println(foodadv.getPageNum());
        System.out.println(foodadv.getPageSize());
        try {
            PageInfo<Foodadv> foodadvs=foodadvservice.Selectfoodadv(foodadv);
            return new CommonResult(200, "查找成功",foodadvs.getList(),foodadvs.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }


    @RequestMapping(value ="/foodadv0")
    public CommonResult foodadv0() {
        try {
            List<Foodadv> foodadvs= foodadvservice.foodadv0();
            return new CommonResult(200, "查找成功",foodadvs);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败", (Manage) null);
        }
    }
    @RequestMapping(value ="/foodadv1")
    public CommonResult foodadv1() {
        try {
            List<Foodadv> foodadvs= foodadvservice.foodadv1();
            return new CommonResult(200, "查找成功",foodadvs);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败", (Manage) null);
        }
    }
    @RequestMapping(value ="/foodadv2")
    public CommonResult foodadv2() {
        try {
            List<Foodadv> foodadvs= foodadvservice.foodadv2();
            return new CommonResult(200, "查找成功",foodadvs);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败", (Manage) null);
        }
    }

    @RequestMapping(value ="Menufigure")
    public CommonResult<String> fileUpload(@RequestParam("adminFile") CommonsMultipartFile adminFile) {
        System.out.println("上传头像");
        CommonResult<String> commonResult = null;
        //指定文件地址  localhost
        File folder = new File("D:\\apache-tomcat-9.0.431\\webapps\\ROOT\\EPC\\food");
        //linux地址
        //File folder = new File("/usr/local/apache-tomcat-9.0.37-img/webapps/ROOT/springboot/admin/" + adminId);
        if (!folder.exists()) {
            boolean mkdir = folder.mkdir();
            System.out.println("文件创建:" + mkdir);
        }
        //生成新文件
        String oldFileName = adminFile.getOriginalFilename();
        String newFileName = StringUtil.newFileName(oldFileName);
        System.out.println(oldFileName);
        System.out.println(newFileName);
        File file = new File(folder, newFileName);
        System.out.println(file);
        try {
            //只上传问价,不存数据库
            adminFile.transferTo(file);
            String imgUrl = "http://127.0.0.1:8000/EPC/food/" + newFileName;
            //String imgUrl = "http://192.168.32.128:8000/springboot/admin/" + adminId + "/" + newFileName;
            commonResult = new CommonResult<>(200, "上传成功,保存后更换", imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }




    @RequestMapping(value ="/addfoodadv")
    public CommonResult addfoodadv(@RequestBody Foodadv foodadv){
        System.out.println(foodadv);
        foodadv.setFile(StringUtil.subFileType1(foodadv.getFile()));
        System.out.println(foodadv);
        try {
            foodadvservice.addfoodadv(foodadv);
            return new CommonResult(200, "查找成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    @RequestMapping(value ="/updatefoodadv")
    public CommonResult updatefoodadv(@RequestBody Foodadv foodadv){
        System.out.println(foodadv);
        foodadv.setFile(StringUtil.subFileType1(foodadv.getFile()));
        System.out.println(foodadv);
        try {
            foodadvservice.updatefoodadv(foodadv);
            return new CommonResult(200, "查找成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    @RequestMapping(value ="/updatefoodadvid/{id}")
    public CommonResult updatefoodadvid(@PathVariable("id") Integer id){

        try {
            Foodadv foodadv=foodadvservice.updatefoodadvid(id);
            return new CommonResult(200, "查找成功",foodadv);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    @RequestMapping(value ="/streportfoodadv")
    public CommonResult streportfoodadv(){

        try {
            Map<String,List> map = foodadvservice.streportfoodadv();
            return new CommonResult(200, "查找成功",map);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }







    @RequestMapping(value ="/deletefoodadv/{id}")
    public CommonResult delectfood(@PathVariable("id") Integer id){

        try {
            foodadvservice.deletefoodadv(id);
            return new CommonResult(200, "删除成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }
}