package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.Fooddao;
import com.ffyc.myfirstboot.model.Food;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Foodservice {
    @Autowired
    Fooddao fooddao;

    public PageInfo<Food> Selectfood(Food food) {
        PageHelper.startPage(food.getPageNum(), food.getPageSize());
        List<Food> list =  fooddao.Selectfood(food);//分页查询后的数据
        System.out.println(list);
        PageInfo<Food> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    public PageInfo<Food> Selectfood1(Food food) {
        PageHelper.startPage(food.getPageNum(), food.getPageSize());
        List<Food> list =  fooddao.Selectfood1(food);//分页查询后的数据
        System.out.println(list);
        PageInfo<Food> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public Food Selectfoodid(Integer id) {
        return fooddao.Selectfoodid(id);
    }

    public void updatefood(Food food) {
        fooddao.updatefood(food);
    }

    public void savefood(Food food) {
        fooddao.savefood(food);
    }

    public void delectfood(Integer id) {
        fooddao.delectfood(id);
    }

    public PageInfo<Food> shoppingcar(Food food) {
        PageHelper.startPage(food.getPageNum(), food.getPageSize());
        List<Food> list =  fooddao.shoppingcar(food);//分页查询后的数据
        System.out.println(list);
        PageInfo<Food> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public PageInfo<Food> shoppingcar5(Food food) {
        PageHelper.startPage(food.getPageNum(), food.getPageSize());
        List<Food> list =  fooddao.shoppingcar5(food);//分页查询后的数据
        System.out.println(list);
        PageInfo<Food> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }





    public void deleteshopcar(Integer id) {
        fooddao.deleteshopcar(id);
    }

}
