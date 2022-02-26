package com.ffyc.myfirstboot.controller;

import com.ffyc.myfirstboot.model.Student;
import com.ffyc.myfirstboot.service.FrontLoginService;
import com.ffyc.myfirstboot.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/frontlogin")
public class FrontLoginController {
    @Autowired
    FrontLoginService frontLoginService;

    @RequestMapping("/login")
    public CommonResult login(@RequestBody Student student){
       Student student1= frontLoginService.login(student);
        if(student1!=null){
            return  new CommonResult(200,"登录成功",student1);
        }else{
            return  new CommonResult(300,"账号或者密码错误",null);
        }
    }
}
