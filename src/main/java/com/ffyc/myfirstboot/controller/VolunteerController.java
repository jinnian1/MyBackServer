package com.ffyc.myfirstboot.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ffyc.myfirstboot.model.Volunteer;
import com.ffyc.myfirstboot.service.VolunteerService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.TokenUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Deevan
 */
@RestController
@RequestMapping("api/volunteer")
public class VolunteerController {

    @Autowired
    VolunteerService volunteerService;

    @RequestMapping("addVolunteer/{type}")
    public CommonResult addVolunteer(@RequestHeader("token") String token, @PathVariable("type")Integer type) {
        CommonResult commonResult = null;
        /*DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer studentId = tokenInfo.getClaim("id").asInt();
        volunteer.setStudentID(studentId);*/
        Volunteer volunteer = new Volunteer();
        volunteer.setStudentID(2);
        volunteer.setType(type);
        volunteerService.addVolunteer(volunteer);
        try {
            commonResult = new CommonResult<>(200, "申请成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("deleteVolunteer/{volunteerId}")
    public CommonResult deleteVolunteer(@PathVariable("volunteerId") Integer volunteerId) {
        CommonResult commonResult = null;
        volunteerService.deleteVolunteer(volunteerId);
        try {
            commonResult = new CommonResult<>(200, "删除成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("updateGet/{volunteerId}")
    public CommonResult<Volunteer> updateGet(@PathVariable("volunteerId") Integer volunteerId) {
        CommonResult<Volunteer> commonResult = null;
        Volunteer volunteer = volunteerService.updateGet(volunteerId);
        try {
            commonResult = new CommonResult<>(200, "查找成功", volunteer);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("updateVolunteer")
    public CommonResult  updateVolunteer(@RequestHeader("token") String token,@RequestBody Volunteer volunteer) {
        CommonResult commonResult = null;
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer manageId = tokenInfo.getClaim("id").asInt();
        volunteer.setOperator(manageId);
        volunteerService.updateVolunteer(volunteer);
        try {
            commonResult = new CommonResult<>(200, "修改成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("getVolunteerList")
    public CommonResult<List<Volunteer>> getVolunteerList(@RequestBody Volunteer volunteer){
        CommonResult commonResult = null;
        try {
            PageInfo<Volunteer> volunteerPageInfo = volunteerService.getVolunteerList(volunteer);
            commonResult = new CommonResult<>(200, "查询成功", volunteerPageInfo.getList(), volunteerPageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "查询失败", null);
        }
        return commonResult;
    }

    /**
     * 查询学生是否为志愿者 是返回状态
     */
    @RequestMapping("isVolunteer/{studentId}")
    public CommonResult<Integer> isVolunteer(@PathVariable("studentId")Integer studentId){
        CommonResult commonResult = null;
        try {
            Integer state = volunteerService.isVolunteer(studentId);
            commonResult = new CommonResult<>(200, "查询成功", state);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "查询失败", null);
        }
        return commonResult;
    }
}
