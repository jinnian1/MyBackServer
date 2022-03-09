package com.ffyc.myfirstboot.controller;

import com.ffyc.myfirstboot.model.Appointment;
import com.ffyc.myfirstboot.model.Psychologist;
import com.ffyc.myfirstboot.service.PsychologistService;
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
@RequestMapping("/api/Psychologist")
public class ControllerPsychologist {
    @Autowired
    PsychologistService psychologistService;

    @RequestMapping("/search")
    public CommonResult psychologistList(@RequestBody Psychologist psychologist){
        try {
            PageInfo<Psychologist> pageInfo = psychologistService.psyList(psychologist);
            return new CommonResult(200, "查找成功", pageInfo.getList(),pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<Psychologist>(300, "查找失败", null);
        }
    }
    @RequestMapping("/searchdoctor")
    public CommonResult doctorList(){
        try {
            List<Psychologist>list=psychologistService.searchdoctor();
            return new CommonResult(200, "查找成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<Psychologist>(300, "查找失败", null);
        }
    }
    @RequestMapping("/adddoctorpicture")
    public CommonResult<String> fileUpload(@RequestParam("fileName") CommonsMultipartFile infoImg) {
        CommonResult<String> commonResult = null;
        //指定文件地址  localhost
        File folder = new File("D:\\apache-tomcat-9.0.43\\webapps\\ROOT");
        if (!folder.exists()) {
            folder.mkdir();
        }
        //生成新文件
        String fileName = StringUtil.getNewFileName(infoImg.getOriginalFilename());
        File file = new File(folder, fileName);
        try {
            //只上传文件,不存数据库
            infoImg.transferTo(file);
            //返回文件名
            commonResult = new CommonResult<>(200, "上传成功,保存后修改", fileName);
        } catch (IOException e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }
    @RequestMapping("/addDoctor")
    public CommonResult<String> addDoctor(@RequestBody Psychologist psychologist) {
        try {
            psychologistService.addDoctor(psychologist);
            return new CommonResult(200, "保存成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "保存失败",null);
        }
    }
    @RequestMapping("/updateDoctor/{id}")
    public CommonResult<String> updateDoctor(@PathVariable("id")Integer id) {
        try {

           Psychologist psychologist= psychologistService.updateDoctor(id);
            return new CommonResult(200, "查询成功",psychologist);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "保存失败",null);
        }
    }
    @RequestMapping("/updateDoctorSave")
    public CommonResult<String> updateDoctorSave(@RequestBody Psychologist psychologist) {
        try {
            psychologistService.updateDoctorSave(psychologist);
            return new CommonResult(200, "更新成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "更新失败",null);
        }
    }
    @RequestMapping("/delete/{id}")
    public CommonResult psychologistDelete(@PathVariable("id")Integer id){
        try {
            psychologistService.psychologistDelete(id);
            return new CommonResult(200, "删除成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<Psychologist>(300, "删除失败", null);
        }
    }

}
