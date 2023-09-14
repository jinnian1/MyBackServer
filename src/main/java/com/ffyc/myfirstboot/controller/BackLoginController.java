package com.ffyc.myfirstboot.controller;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.model.Menu;
import com.ffyc.myfirstboot.service.AdminService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login")
public class BackLoginController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public CommonResult login(@RequestBody Manage manage){
        CommonResult commonResult=null;
        try {
            Manage manage1= adminService.login(manage);
            System.out.println("manage1---"+manage1);
            if (manage1!=null){
                String token= TokenUtil.token(manage1.getId(),manage1.getAccount(),manage1.getType());
                manage1.setToken(token);
                System.out.println("manage2---"+manage1);
                commonResult=new CommonResult(200,"登录成功",manage1);
                return commonResult;
            }else {
                commonResult=new CommonResult(201,"账号或密码错误",null);
                return commonResult;
            }

        } catch (Exception e) {
            e.printStackTrace();
            commonResult=new CommonResult(500,"服务器忙",null);
            return commonResult;
        }
    }
    @RequestMapping(value ="/menuList")
    public CommonResult menuList(@RequestHeader String token) {
        try {
            DecodedJWT decodedJWT= TokenUtil.getTokenInfo(token);
            Integer type=0;
            Integer id=decodedJWT.getClaim("id").asInt();
            System.out.println(type);
            System.out.println(id);
            List<Menu> menuList = adminService.menuList(type,id);
            if (menuList != null) {
                return new CommonResult<>(200, "查询成功", menuList);
            } else {
                return new CommonResult(300, "查询失败",null);
            }
        } catch (Exception e) {
            return new CommonResult(300, "查询失败", null);
        }
    }



    @RequestMapping(value ="/register")
    public CommonResult register(@RequestBody Manage manage) {
        try {
            adminService.register(manage);
                return new CommonResult<>(200, "注册成功", null);
        } catch (Exception e) {
            System.out.println(e);
            return new CommonResult(300, "注册失败", null);
        }
    }

    @RequestMapping(value ="/getManageInfo{id}")
    public CommonResult getManageInfo(@PathVariable("id") Integer id) {
        try {
            System.out.println(id);
            Manage manage=adminService.getManageInfo(id);
            return new CommonResult<>(200, "成功", manage);
        } catch (Exception e) {
            System.out.println(e);
            return new CommonResult(300, "失败", null);
        }
    }
    @RequestMapping(value ="/updateManageInfo")
    public CommonResult updateManageInfo(@RequestBody Manage manage) {
        try {
           adminService.updateManageInfo(manage);
            return new CommonResult<>(200, "修改成功", null);
        } catch (Exception e) {
            System.out.println(e);
            return new CommonResult(300, "失败", null);
        }
    }
}
