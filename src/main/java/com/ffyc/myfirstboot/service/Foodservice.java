package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.Foodadvdao;
import com.ffyc.myfirstboot.dao.Fooddao;
import com.ffyc.myfirstboot.model.Food;
import com.ffyc.myfirstboot.model.Foodadv;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Foodservice {
    @Autowired
    Fooddao fooddao;

    public PageInfo<Food> Selectfood(Food food) {
        PageHelper.startPage(food.getPageNum(), food.getPageSize());
        List<Food> list =  fooddao.Selectfood();//分页查询后的数据
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
}
