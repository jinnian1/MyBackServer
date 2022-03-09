package com.ffyc.myfirstboot.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.model.Menu;
import com.ffyc.myfirstboot.model.Role;
import com.ffyc.myfirstboot.service.RoleService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.TokenUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping("/menuList")
    public CommonResult menuList(){
        try {
            List<Menu>menuList= roleService.menuList();
            return  new CommonResult(200,"查找成功",menuList);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"查找失败",null);
        }
    }
    @RequestMapping("/save")
    public CommonResult save(@RequestHeader("token") String token, @RequestBody Role role){
        try {
            DecodedJWT decodedJWT= TokenUtil.getTokenInfo(token);
            Integer operatePerson=decodedJWT.getClaim("id").asInt();
            role.setOperatePerson(operatePerson);
            roleService.save(role);
            return  new CommonResult(200,"保存成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"保存失败",null);
        }
    }
    @RequestMapping("/delete/{id}")
    public CommonResult save(@RequestHeader("token") String token,@PathVariable("id")Integer id){
        try {
            DecodedJWT decodedJWT= TokenUtil.getTokenInfo(token);
            Integer operatePerson=decodedJWT.getClaim("id").asInt();
            Role role=new Role();
            role.setOperatePerson(operatePerson);
            role.setId(id);
            roleService.delete(role);
            return  new CommonResult(200,"删除成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"删除失败",null);
        }
    }
    @RequestMapping("/update/{id}")
    public CommonResult update(@PathVariable("id")Integer id){
        try {
          Role role=roleService.update(id);
            return  new CommonResult(200,"查询成功",role);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"查询失败",null);
        }
    }
    @RequestMapping("/updateSave")
    public CommonResult updateSave(@RequestHeader("token") String token,@RequestBody Role role){
        try {
            DecodedJWT decodedJWT= TokenUtil.getTokenInfo(token);
            Integer operatePerson=decodedJWT.getClaim("id").asInt();
            role.setOperatePerson(operatePerson);
            roleService.updateSave(role);
            return  new CommonResult(200,"更新成功",role);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(300,"更新失败",null);
        }
    }

}
