package com.ffyc.myfirstboot.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ffyc.myfirstboot.model.Express;
import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.service.ExpressService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.TokenUtil;
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
    public CommonResult expressList(@RequestBody Express express) {
        try {
            PageInfo<Express> pageInfo = expressService.expressList(express);
            return new CommonResult(200, "查找成功", pageInfo.getList(), pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<Express>(300, "查找失败", (Express) null);
        }
    }
    @RequestMapping("/searchOver")
    public CommonResult searchOver(@RequestBody Express express) {
        try {
            PageInfo<Express> pageInfo = expressService.searchOver(express);
            return new CommonResult(200, "查找成功", pageInfo.getList(), pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<Express>(300, "查找失败", (Express) null);
        }
    }


    @RequestMapping("/delete/{id}")
    public CommonResult expressDelete(@PathVariable("id") Integer id) {
        try {
            expressService.delete(id);
            return new CommonResult(200, "删除成功", null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "删除失败", null, null);
        }
    }

    @RequestMapping("/save")
    public CommonResult saveExpress(@RequestBody Express express) {
        try {
            expressService.save(express);
            return new CommonResult(200, "保存成功", null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "保持失败", null, null);
        }
    }

    @RequestMapping("/updateExpress/{id}")
    public CommonResult updateExpress(@PathVariable("id") Integer id) {
        try {
            Express express = expressService.updateExpress(id);
            return new CommonResult(200, "查询成功", express);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查询失败", null);
        }
    }

    @RequestMapping("/updateSave")
    public CommonResult updateSave(@RequestHeader("token") String token, @RequestBody Express express) {
        try {
            DecodedJWT decodedJWT = TokenUtil.getTokenInfo(token);
            Integer operatePerson = decodedJWT.getClaim("id").asInt();
            express.setOperatePerson(operatePerson);
            expressService.updateSave(express);
            return new CommonResult(200, "更新成功", null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "更新失败", null, null);
        }
    }
    @RequestMapping("/frontSubmit")
    public CommonResult frontSubmit(@RequestBody Express express) {
        try {
            expressService.frontSubmit(express);
            return new CommonResult(200, "提交成功", null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "提交失败", null, null);
        }
    }

}
