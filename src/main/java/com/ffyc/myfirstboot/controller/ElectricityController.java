package com.ffyc.myfirstboot.controller;
import com.ffyc.myfirstboot.model.*;
import com.ffyc.myfirstboot.service.ElectricityService;
import com.ffyc.myfirstboot.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/electricity")
public class ElectricityController {
    @Autowired
    ElectricityService electricityService;

    @RequestMapping("/electricityMessage{studentId}")
    public CommonResult electricityMessage(@PathVariable("studentId")Integer studentId){
        CommonResult commonResult=null;
        try {
            System.out.println(studentId);
            List<Electricity> electricityList=electricityService.electricityMessage(studentId);
            System.out.println(electricityList);
            return new CommonResult(200,"查找成功",electricityList);
        } catch (Exception e) {
            e.printStackTrace();
          return    new CommonResult(500, "服务器忙", null);
        }
        }


    @RequestMapping("/getReportEle")
    public CommonResult getReportEle(){
        try {
            Map<String,List> map = electricityService.getReportEle();
            System.out.println(map);
            return new CommonResult(200,"查找成功",map);
        } catch (Exception e) {
            e.printStackTrace();
            return    new CommonResult(500, "服务器忙", null);
        }
    }

    @RequestMapping("/getBillingInfoList")
    public CommonResult getBillingInfoList(@RequestBody Student student){
        CommonResult commonResult=null;
        try {
            List<Electricity> electricityList=electricityService.getBillingInfoList(student);
            System.out.println("1111111"+electricityList);
            return new CommonResult(200,"查找成功",electricityList);
        } catch (Exception e) {
            e.printStackTrace();
            return    new CommonResult(500, "服务器忙", null);
        }
    }

    @RequestMapping("/reportEle{studentID}")
    public CommonResult reportEle(@PathVariable Integer studentID){
        try {
            Map<String,List> map = electricityService.reportEle(studentID);
            return new CommonResult(200, "查找成功",map);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    @RequestMapping("/billingInfoSave")
    public CommonResult billingInfoSave(@RequestBody Electricity electricity){
        try {
            electricityService.billingInfoSave(electricity);
            return new CommonResult(200, "充值成功，待审核",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查询失败", null);
        }
    }
    @RequestMapping("/updateBillingInfo")
    public CommonResult updateBillingInfo(@RequestBody Electricity electricity){
        try {

            electricityService.updateBillingInfo(electricity);
            return new CommonResult(200, "处理成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查询失败", null);
        }
    }
    @RequestMapping("/deleteBillingInfo/{id}")
    public CommonResult deleteBillingInfo(@PathVariable Integer id){
        try {

            electricityService.deleteBillingInfo(id);
            return new CommonResult(200, "处理成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查询失败", null);
        }
    }

    @RequestMapping("/getBillStatisticsList")
    public CommonResult getBillStatisticsList(){
        try {

          List<Room> rooms= electricityService.getBillStatisticsList();
            return new CommonResult(200, "处理成功",rooms);
        } catch (Exception e) {
            e.printStackTrace();

            return new CommonResult(300, "查询失败", null);
        }
    }


    @RequestMapping("/getTotalBill")
    public CommonResult getTotalBill(){
        try {

            BillingInfo billingInfo= electricityService.getTotalBill();
            return new CommonResult(200, "处理成功",billingInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查询失败", null);
        }
    }
}
