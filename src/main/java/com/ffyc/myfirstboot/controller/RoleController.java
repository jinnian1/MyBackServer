package com.ffyc.myfirstboot.controller;

import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.model.Role;
import com.ffyc.myfirstboot.service.RoleService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/search")
    public CommonResult search(@RequestBody Role role){
        try {
            PageInfo<Role> pageInfo = roleService.search(role);
            return  new CommonResult(200,"查找成功",pageInfo.getList(),pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"查找失败",null);
        }
    }
}
