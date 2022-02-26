package com.ffyc.myfirstboot.controller;

import com.ffyc.myfirstboot.model.Appointment;
import com.ffyc.myfirstboot.service.AppointmentService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Appointment")
public class ControllerAppointment {
    @Autowired
    AppointmentService appointmentService;

    @RequestMapping("/search")
    public CommonResult search(@RequestBody Appointment appointment){
        try {
            PageInfo<Appointment> pageInfo = appointmentService.appointmentList(appointment);
            return new CommonResult(200,"查找成功",pageInfo.getList(),pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300,"查找失败",null);
        }
    }
    @RequestMapping("/searchover")
    public CommonResult searchover(@RequestBody Appointment appointment){
        try {
            PageInfo<Appointment> pageInfo = appointmentService.appointmentListOver(appointment);
            return new CommonResult(200,"查找成功",pageInfo.getList(),pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300,"查找失败",null);
        }
    }
}
