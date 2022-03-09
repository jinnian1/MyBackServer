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

@RestController
@RequestMapping("/api")
public class Foodcontroller {
    @Autowired
    Foodservice foodservice;

    @RequestMapping(value ="/food")
    public CommonResult Food(@RequestBody Food food){
        System.out.println(food.getPageNum());
        System.out.println(food.getPageSize());
        System.out.println(food);
        try {
            PageInfo<Food> foods=foodservice.Selectfood(food);
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
        System.out.println(food);
        try {
            foodservice.updatefood(food);
            return new CommonResult(200, "查找成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }




    @RequestMapping(value ="/foodsave")
    public CommonResult foodsave(@RequestBody Food food){
        System.out.println(food);
        try {
            foodservice.savefood(food);
            return new CommonResult(200, "查找成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }

    @RequestMapping(value ="/delectfood/{id}")
    public CommonResult delectfood(@PathVariable("id") Integer id){

        try {
            foodservice.delectfood(id);
            return new CommonResult(200, "删除成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<>(300, "查找失败",  null);
        }
    }
}