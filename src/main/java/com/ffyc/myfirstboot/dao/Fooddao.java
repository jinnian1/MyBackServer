package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Food;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Fooddao {
    List<Food> shoppingcar(Food food);
    List<Food> shoppingcar5(Food food);

    List<Food> Selectfood(Food food);
    List<Food> Selectfood1(Food food);
    Food Selectfoodid(Integer id);

    void updatefood(Food food);


    void savefood(Food food);

    void delectfood(Integer id);

    void deleteshopcar(Integer id);
}
