package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Dailyuse;
import com.ffyc.myfirstboot.model.Dailyuseadv;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dailyusedao {
    List<Dailyuse> shoppingcar1(Dailyuse dailyuse);
    List<Dailyuse> shoppingcar6(Dailyuse dailyuse);
    List<Dailyuse> SelectDaily(Dailyuse dailyuse);
    List<Dailyuse> SelectDaily1(Dailyuse dailyuse);

    Dailyuseadv Selectdailyid(Integer id);

    Dailyuse updatedailyuseid(Integer id);

    void updatedailyuse(Dailyuse dailyuse);

    void dailyusesave(Dailyuse dailyuse);

    void deletedailyuse(Integer id);

    void deleteshopcar1(Integer id);
}
