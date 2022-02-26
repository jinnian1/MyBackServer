package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Food;
import com.ffyc.myfirstboot.model.Foodadv;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Fooddao {


    List<Food> Selectfood();

    Food Selectfoodid(Integer id);

    void updatefood(Food food);

    void savefood(Food food);

    void delectfood(Integer id);
}
