package com.ffyc.myfirstboot.controller;

import com.ffyc.myfirstboot.model.Express;
import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.service.ExpressService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/express")
public class ControllerExpress {
    @Autowired
    ExpressService expressService;

    @RequestMapping("/search")
    public CommonResult expressList(@RequestBody Express express){
        try {
            PageInfo<Express> pageInfo = expressService.expressList(express);
            return new CommonResult(200, "查找成功", pageInfo.getList(),pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<Express>(300, "查找失败", (Express) null);
        }
    }
    @RequestMapping("/delete/{id}")
    public CommonResult expressDelete(@PathVariable("id") Integer id){
        try {
            expressService.delete(id);
            return new CommonResult(200, "删除成功", null,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "删除失败", null,null);
        }
    }
    @RequestMapping("/save")
    public CommonResult saveExpress(@RequestBody Express express){
        try {
          expressService.save(express);
          return  new CommonResult(200,"保存成功",null,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "保持失败", null,null);
        }
    }
}
