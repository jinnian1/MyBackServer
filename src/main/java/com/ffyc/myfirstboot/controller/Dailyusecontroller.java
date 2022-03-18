package com.ffyc.myfirstboot.controller;


import com.ffyc.myfirstboot.model.Dailyuse;
import com.ffyc.myfirstboot.model.Dailyuseadv;
import com.ffyc.myfirstboot.model.Food;
import com.ffyc.myfirstboot.service.Dailyuseservice;
import com.ffyc.myfirstboot.util.CommonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Dailyusecontroller {
    @Autowired
    Dailyuseservice dailyuseservice;

    @RequestMapping(value ="/dailyuse")
    public CommonResult Dailyuse(@RequestBody Dailyuse dailyuse){
        try {
            PageInfo<Dailyuse> dailyuses=dailyuseservice.Selectdailyuse(dailyuse);
            return new CommonResult(200, "查找成功",dailyuses.getList(),dailyuses.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    @RequestMapping(value ="/dailyuse1")
    public CommonResult Dailyuse1(@RequestBody Dailyuse dailyuse){
        try {
            PageInfo<Dailyuse> dailyuses=dailyuseservice.Selectdailyuse1(dailyuse);
            return new CommonResult(200, "查找成功",dailyuses.getList(),dailyuses.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    @RequestMapping(value ="/dailyuseid/{id}")
    public CommonResult Foodid(@PathVariable("id") Integer id){
        try {
            Dailyuseadv dailyuse=dailyuseservice.Selectdailyuseid(id);
            return new CommonResult(200, "查找成功",dailyuse);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }


    @RequestMapping(value ="/updatedailyuesid/{id}")
    public CommonResult updatedailyuesid(@PathVariable("id") Integer id){

        try {
            Dailyuse dailyuse=dailyuseservice.updatedailyuseid(id);
            return new CommonResult(200, "更新成功",dailyuse);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "更新失败",  null);
        }
    }


    @RequestMapping(value ="/updatedailyuse")
    public CommonResult updatedailyuse(@RequestBody Dailyuse dailyuse){

        try {
           dailyuseservice.updatedailyuse(dailyuse);
            return new CommonResult(200, "修改成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }


    @RequestMapping(value ="/dailyusesave")
    public CommonResult dailyusesave(@RequestBody Dailyuse dailyuse){
        try {
            dailyuseservice.dailyusesave(dailyuse);
            return new CommonResult(200, "提交成功，在个人中心查看",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "提交失败，服务器忙",  null);
        }
    }

    @RequestMapping(value ="/deleteshopcar1/{id}")
    public CommonResult deleteshopcar1(@PathVariable("id") Integer id){
        try {
            dailyuseservice.deleteshopcar1(id);
            return new CommonResult(200, "取消订单成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "取消订单失败，服务器忙或订单已被接单",  null);
        }
    }




    @RequestMapping(value ="/deletedailyuse/{id}")
    public CommonResult delectfood(@PathVariable("id") Integer id){
        try {
            dailyuseservice.deletedailyuse(id);
            return new CommonResult(200, "删除订单成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "删除订单失败，服务器忙或订单已被接单",  null);
        }
    }

    @RequestMapping(value ="/shoppingcar1")
    public CommonResult shoppingcar1(@RequestBody Dailyuse dailyuse){
        try {
            PageInfo<Dailyuse> dailyuses =dailyuseservice.shoppingcar1(dailyuse);
            return new CommonResult(200, "查找成功",dailyuses.getList(),dailyuses.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    @RequestMapping(value ="/shoppingcar6")
    public CommonResult shoppingcar6(@RequestBody Dailyuse dailyuse){
        try {
            PageInfo<Dailyuse> dailyuses =dailyuseservice.shoppingcar6(dailyuse);
            return new CommonResult(200, "查找成功",dailyuses.getList(),dailyuses.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }
}