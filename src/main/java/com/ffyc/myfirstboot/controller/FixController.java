package com.ffyc.myfirstboot.controller;

import com.ffyc.myfirstboot.model.Breakdownfix;
import com.ffyc.myfirstboot.model.Electricity;
import com.ffyc.myfirstboot.model.Student;
import com.ffyc.myfirstboot.service.ElectricityService;
import com.ffyc.myfirstboot.service.FixService;
import com.ffyc.myfirstboot.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FixController {
    @Autowired
    FixService fixService;

    @RequestMapping("/getBreakDownFix")
    public CommonResult getBreakDownFix(){
        CommonResult commonResult=null;
        try {

            List<Breakdownfix> breakdownfixes=fixService.getBreakDownFix();
            System.out.println(breakdownfixes);
            return new CommonResult(200,"查找成功",breakdownfixes);
        } catch (Exception e) {
            e.printStackTrace();
          return    new CommonResult(500, "服务器忙", null);
        }
        }

    @RequestMapping("/submitFix")
    public CommonResult submitFix(@RequestBody Breakdownfix breakdownfix){
        CommonResult commonResult=null;
        try {
            System.out.println(888);
           fixService.submitFix(breakdownfix);
            return new CommonResult(200,"已提交，待管理员审查",null);
        } catch (Exception e) {
            e.printStackTrace();
            return    new CommonResult(500, "服务器忙", null);
        }
    }

    @RequestMapping("/submitFeedBack")
    public CommonResult submitFeedBack(@RequestBody Breakdownfix breakdownfix){
        CommonResult commonResult=null;
        try {
            fixService.submitFeedBack(breakdownfix);
            return new CommonResult(200,"已提交，待管理员审查",null);
        } catch (Exception e) {
            e.printStackTrace();
            return    new CommonResult(500, "服务器忙", null);
        }
    }

    @RequestMapping("/deleteBreakDownFix/{id}")
    public CommonResult deleteBreakDownFix(@PathVariable Integer id){
        try {

            fixService.deleteBreakDownFix(id);
            return new CommonResult(200, "处理成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查询失败", null);
        }
    }
}
