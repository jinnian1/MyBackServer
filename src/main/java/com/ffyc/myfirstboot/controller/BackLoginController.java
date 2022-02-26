package com.ffyc.myfirstboot.controller;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.model.Menu;
import com.ffyc.myfirstboot.service.HelloService;
import com.ffyc.myfirstboot.service.AdminService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/login")
public class BackLoginController {
    @Autowired
    HelloService helloService;
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public CommonResult login(@RequestBody Manage manage){
        CommonResult commonResult=null;
        try {
            Manage manage1= adminService.login(manage);

            if (manage1!=null){
                String token= TokenUtil.token(manage1.getId(),manage1.getAccount(),manage1.getType());
                manage1.setToken(token);
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
    @RequestMapping("/test")
    public void test() {
        System.out.println("测试成功");
    }

    @RequestMapping(value ="/menuList")
    public CommonResult menuList(@RequestHeader String token) {
        try {
            DecodedJWT decodedJWT= TokenUtil.getTokenInfo(token);
            Integer type=decodedJWT.getClaim("type").asInt();
            Integer id=decodedJWT.getClaim("id").asInt();
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
}
