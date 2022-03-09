package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.Foodadvdao;
import com.ffyc.myfirstboot.model.Foodadv;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Foodadvservice {
    @Autowired
    Foodadvdao foodadvdao;

    public PageInfo<Foodadv> Selectfoodadv(Foodadv foodadv) {
        PageHelper.startPage(foodadv.getPageNum(), foodadv.getPageSize());
        List<Foodadv> list =  foodadvdao.Selectfoodadv(foodadv);//分页查询后的数据
        PageInfo<Foodadv> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public List<Foodadv> foodadv0() {
        return foodadvdao.foodadv0();
    }
    public List<Foodadv> foodadv1() {
        return foodadvdao.foodadv1();
    }
    public List<Foodadv> foodadv2() {
        return foodadvdao.foodadv2();
    }

    public void deletefoodadv(Integer id) {
        foodadvdao.deletefoodadv(id);
    }

    public void addfoodadv(Foodadv foodadv) {
        foodadvdao.addfoodadv(foodadv);
    }

    public void updatefoodadv(Foodadv foodadv) {
        foodadvdao.updatefoodadv(foodadv);
    }

    public Foodadv updatefoodadvid(Integer id) {
        return foodadvdao.updatefoodadvid(id);
    }

    public Map<String, List> streportfoodadv() {
        Map<String, List> map = new HashMap<>();
      /*  List<String> typeList = foodadvdao.findTypeName();
        List<Integer> countList = foodadvdao.countByTypeList();*/
        List<String> typeList = Arrays.asList(new String[]{"21", "12", "21"});
        List<Integer> countList = Arrays.asList(new Integer[]{23, 23, 23});
        map.put("x", typeList);
        map.put("y", countList);
        return map;
    }
}
