package com.ffyc.myfirstboot.controller;


import com.ffyc.myfirstboot.model.Food;
import com.ffyc.myfirstboot.service.Foodservice;
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
public class Foodcontroller {
    @Autowired
    Foodservice foodservice;

    @RequestMapping(value ="/food")
    public CommonResult Food(@RequestBody Food food){
        try {
            PageInfo<Food> foods=foodservice.Selectfood(food);
            return new CommonResult(200, "查找成功",foods.getList(),foods.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    @RequestMapping(value ="/Selectfood1")
    public CommonResult Food1(@RequestBody Food food){
        try {
            PageInfo<Food> foods=foodservice.Selectfood1(food);
            return new CommonResult(200, "查找成功",foods.getList(),foods.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    @RequestMapping(value ="/foodid/{id}")
    public CommonResult Foodid(@PathVariable("id") Integer id){

        try {
            Food foods=foodservice.Selectfoodid(id);
            return new CommonResult(200, "查找成功",foods);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    @RequestMapping(value ="/updatefood")
    public CommonResult updatefood(@RequestBody Food food){
        try {
            foodservice.updatefood(food);
            return new CommonResult(200, "更新成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "更新失败",  null);
        }
    }





    @RequestMapping(value ="/foodsave")
    public CommonResult foodsave(@RequestBody Food food){
        try {
            foodservice.savefood(food);
            return new CommonResult(200, "提交成功，在个人中心查看",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "提交失败，服务器忙",  null);
        }
    }

    @RequestMapping(value ="/delectfood/{id}")
    public CommonResult delectfood(@PathVariable("id") Integer id){

        try {
            foodservice.delectfood(id);
            return new CommonResult(200, "删除订单成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "删除订单失败，服务器忙或订单已被接单",  null);
        }
    }
    @RequestMapping(value ="/deleteshopcar/{id}")
    public CommonResult deleteshopcar(@PathVariable("id") Integer id){
        try {
            foodservice.deleteshopcar(id);
            return new CommonResult(200, "取消订单成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "取消订单失败，服务器忙或订单已被接单",  null);
        }
    }




    @RequestMapping(value ="/shoppingcar")
    public CommonResult shoppingcar(@RequestBody Food food){
        try {
            PageInfo<Food> foods =foodservice.shoppingcar(food);
            return new CommonResult(200, "查找成功",foods.getList(),foods.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    @RequestMapping(value ="/shoppingcar5")
    public CommonResult shoppingcar5(@RequestBody Food food){
        try {
            PageInfo<Food> foods =foodservice.shoppingcar5(food);
            return new CommonResult(200, "查找成功",foods.getList(),foods.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    }
