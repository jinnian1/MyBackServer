package com.ffyc.myfirstboot.controller;

import com.ffyc.myfirstboot.model.Psychologist;
import com.ffyc.myfirstboot.service.PsychologistService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
