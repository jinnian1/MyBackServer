package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.Dailyuseadvdao;
import com.ffyc.myfirstboot.model.Dailyuseadv;
import com.ffyc.myfirstboot.model.Food;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Dailyuseadvservice {
    @Autowired
    Dailyuseadvdao dailyuseadvdao;

    public List<Dailyuseadv> select() {
        return dailyuseadvdao.select();
    }
    public List<Dailyuseadv> select1() {
        return dailyuseadvdao.select1();
    }
    public List<Dailyuseadv> select2() {
        return dailyuseadvdao.select2();
    }
    public List<Dailyuseadv> select3() {
        return dailyuseadvdao.select3();
    }
    public List<Dailyuseadv> select4() {
        return dailyuseadvdao.select4();
    }

    public PageInfo<Dailyuseadv> Backdailyuseadv(Dailyuseadv dailyuseadv) {
        PageHelper.startPage(dailyuseadv.getPageNum(), dailyuseadv.getPageSize());
        List<Dailyuseadv> list =dailyuseadvdao.Backdailyuseadv(dailyuseadv);//分页查询后的数据
        PageInfo<Dailyuseadv> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public void adddailyuseadv(Dailyuseadv dailyuseadv) {
        dailyuseadvdao.adddailyuseadv(dailyuseadv);
    }

    public Dailyuseadv updatedailid(Integer id) {
        return dailyuseadvdao.updatedailid(id);
    }

    public void updatedail(Dailyuseadv dailyuseadv) {
        dailyuseadvdao.updatedail(dailyuseadv);
    }

    public void deletedailyuseadv(Integer id) {
        dailyuseadvdao.deletedailyuseadv(id);
    }
}
