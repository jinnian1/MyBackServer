package com.ffyc.myfirstboot.controller;

import java.io.File;
import com.ffyc.myfirstboot.model.HorseLamp;
import com.ffyc.myfirstboot.model.News;
import com.ffyc.myfirstboot.model.Role;
import com.ffyc.myfirstboot.service.NewsService;
import com.ffyc.myfirstboot.service.RoleService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.StringUtil;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.protocol.x.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/home")
public class NoticeController {
    @Autowired
    NewsService newsService;

    @RequestMapping("/notice")
    public CommonResult notice(){
        try {
            List<News> notice=newsService.getNotice();
            return  new CommonResult(200,"查找成功",notice);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"查找失败",null);
        }
    }

    @RequestMapping("/horseLamp")
    public CommonResult getHorseLamp(){
        try {
            List<HorseLamp> notice=newsService.getHorseLamp();
            return  new CommonResult(200,"查找成功",notice);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"查找失败",null);
        }
    }
    @RequestMapping("/getHorseLampList")
    public CommonResult getHorseLampList(){
        try {
            List<HorseLamp> notice=newsService.getHorseLamp();
            return  new CommonResult(200,"查找成功",notice);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"查找失败",null);
        }
    }
    @RequestMapping("/getFeedBackList")
    public CommonResult getFeedBackList(){
        try {
            List<HorseLamp> notice=newsService.getFeedBackList();
            return  new CommonResult(200,"查找成功",notice);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"查找失败",null);
        }
    }

    @RequestMapping("/picture")
    public CommonResult<String> fileUpload(@RequestParam("File") CommonsMultipartFile File) {
        System.out.println("saassssssss");
        System.out.println(File);
        System.out.println(File.getOriginalFilename());
        CommonResult<String> commonResult = null;
        //linux地址
        File folder = new File("D:\\Program Files\\apache-tomcat-9.0.43\\webapps\\ROOT");
        if (!folder.exists()) {
            boolean mkdir = folder.mkdir();
        }
        //生成新文件
        String oldFileName = File.getOriginalFilename();
        String newFileName = StringUtil.newFileName(oldFileName);
        File file = new File(folder, newFileName);
        try {
            //只上传问价,不存数据库
            File.transferTo(file);
            String imgUrl = "http://127.0.0.1:8080/" + newFileName;
            //String imgUrl = "http://192.168.32.128:8000/springboot/admin/" + adminId + "/" + newFileName;
            commonResult = new CommonResult<>(200, "上传成功,保存后更换", imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("/saveNotice")
    public CommonResult saveNotice(@RequestBody HorseLamp horseLamp){
        try {
            newsService.saveNotice(horseLamp);
            return  new CommonResult(200,"添加成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"添加失败",null);
        }
    }
    @RequestMapping("/updateNotice/{id}")
    public CommonResult updateNotice(@PathVariable("id") Integer id){
        try {
            HorseLamp horseLamp=newsService.updateNotice(id);
            return  new CommonResult(200,"修改成功",horseLamp);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"添加失败",null);
        }
    }
    @RequestMapping("/updateNoticeSave")
    public CommonResult updateNoticeSave(@RequestBody HorseLamp horseLamp){
        try {
            newsService.updateNoticeSave(horseLamp);
            return  new CommonResult(200,"修改成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"添加失败",null);
        }
    }


    @RequestMapping("/deleteNotice/{id}")
    public CommonResult deleteNotice(@PathVariable("id") Integer id){
        try {
            newsService.deleteNotice(id);
            return  new CommonResult(200,"删除成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"删除失败",null);
        }
    }

    @RequestMapping("/deleteFeedBack/{id}")
    public CommonResult deleteFeedBack(@PathVariable("id") Integer id){
        try {
            newsService.deleteFeedBack(id);
            return  new CommonResult(200,"删除成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"删除失败",null);
        }
    }

    @RequestMapping("/addHorseLamp")
    public CommonResult addHorseLamp(@RequestBody HorseLamp horseLamp){
        try {
            horseLamp.setFile(StringUtil.subFileType1(horseLamp.getFile()));
            System.out.println(horseLamp);
            newsService.addHorseLamp(horseLamp);
            return  new CommonResult(200,"查找成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"查找失败",null);
        }
    }

    @RequestMapping("/updateHorseLampBy/{id}")
    public CommonResult updateHorseLampBy(@PathVariable("id") Integer id){
        try {
            HorseLamp horseLamp= newsService.updateHorseLampBy(id);
            return  new CommonResult(200,"查找成功",horseLamp);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"查找失败",null);
        }
    }
    @RequestMapping("/saveUpdateHorseLamp")
    public CommonResult saveUpdateHorseLamp(@RequestBody HorseLamp horseLamp){
        try {
            System.out.println("何文"+horseLamp);
            horseLamp.setFile(StringUtil.subFileType1(horseLamp.getFile()));
           newsService.saveUpdateHorseLamp(horseLamp);
            return  new CommonResult(200,"修改成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"查找失败",null);
        }
    }
    @RequestMapping("/deleteHorseLamp/{id}")
    public CommonResult deleteHorseLamp(@PathVariable("id") Integer id){
        try {
            newsService.deleteHorseLamp(id);
            return  new CommonResult(200,"修改成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"查找失败",null);
        }
    }

}
