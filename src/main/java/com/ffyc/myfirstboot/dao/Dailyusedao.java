package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Dailyuse;
import com.ffyc.myfirstboot.model.Dailyuseadv;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dailyusedao {

    List<Dailyuse> SelectDaily(Dailyuse dailyuse);

    Dailyuseadv Selectdailyid(Integer id);

    Dailyuse updatedailyuseid(Integer id);

    void updatedailyuse(Dailyuse dailyuse);

    void dailyusesave(Dailyuse dailyuse);

    void deletedailyuse(Integer id);
}
