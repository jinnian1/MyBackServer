package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Dailyuseadv;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dailyuseadvdao {

    List<Dailyuseadv> select();
    List<Dailyuseadv> select1();
    List<Dailyuseadv> select2();
    List<Dailyuseadv> select3();
    List<Dailyuseadv> select4();

    List<Dailyuseadv> Backdailyuseadv(Dailyuseadv dailyuseadv);

    void adddailyuseadv(Dailyuseadv dailyuseadv);

    Dailyuseadv updatedailid(Integer id);

    void updatedail(Dailyuseadv dailyuseadv);

    void deletedailyuseadv(Integer id);
}
