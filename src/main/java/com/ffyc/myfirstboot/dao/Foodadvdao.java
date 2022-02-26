package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Foodadv;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Foodadvdao {


    List<Foodadv> Selectfoodadv();

    List<Foodadv> foodadv0();
    List<Foodadv> foodadv1();
    List<Foodadv> foodadv2();

    void deletefoodadv(Integer id);

    void addfoodadv(Foodadv foodadv);

    void updatefoodadv(Foodadv foodadv);

    Foodadv updatefoodadvid(Integer id);

    List<String> findTypeName();

    List<Integer> countByTypeList();
}
