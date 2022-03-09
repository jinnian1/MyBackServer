package com.ffyc.myfirstboot.controller;


import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.service.ManageService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/manage")
public class ControllerManage {
    @Autowired
    ManageService manageService;

    @RequestMapping(value ="/search")
    public CommonResult manageList(@RequestBody Manage manage) {
        try {
            PageInfo<Manage>pageInfo = manageService.manageList(manage);
            return new CommonResult(200, "查找成功", pageInfo.getList(),pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<Manage>(300, "查找失败", (Manage) null);
        }
    }
    @RequestMapping(value ="/roleList")
    public CommonResult roleList(){
        try {
            List<Role>role=manageService.roleList();
            return new CommonResult(200, "查找成功", role);

        } catch (Exception e) {
            return new CommonResult<Role>(300, "查找失败", (Role) null);
        }
    }
    @RequestMapping(value ="/save")
    public CommonResult save(@RequestBody Manage manage){
        try {
            manageService.save(manage);
            return new CommonResult(200, "保存成功", null);

        } catch (Exception e) {
            return new CommonResult(300, "保存失败", null);
        }
    }
    @RequestMapping(value ="/updateManage/{id}")
    public CommonResult updateManage(@PathVariable("id")Integer id) {
        try {
            Manage manage = manageService.updateManage(id);
            return new CommonResult(200, "查找成功", manage);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查找失败",null);
        }
    }
    @RequestMapping(value ="/updateSave")
    public CommonResult updateSaveManage(@RequestBody  Manage manage) {
        try {
            manageService.updateSaveManage(manage);
            return new CommonResult(200, "更新成功", manage);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "更新失败",  null);
        }
    }
    @RequestMapping(value ="/delete/{id}")
    public CommonResult deleteManage(@PathVariable("id")Integer id) {
        try {
            manageService.deleteManage(id);
            return new CommonResult(200, "删除成功",  null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "删除失败", null);
        }
    }

}