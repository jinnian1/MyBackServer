package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.Dailyusedao;
import com.ffyc.myfirstboot.model.Dailyuse;
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
public class Dailyuseservice {
    @Autowired
    Dailyusedao dailyusedao;

    public PageInfo<Dailyuse> Selectdailyuse(Dailyuse dailyuse) {
        PageHelper.startPage(dailyuse.getPageNum(), dailyuse.getPageSize());
        List<Dailyuse> list =  dailyusedao.SelectDaily(dailyuse);//分页查询后的数据
        PageInfo<Dailyuse> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    public PageInfo<Dailyuse> Selectdailyuse1(Dailyuse dailyuse) {
        PageHelper.startPage(dailyuse.getPageNum(), dailyuse.getPageSize());
        List<Dailyuse> list =  dailyusedao.SelectDaily1(dailyuse);//分页查询后的数据
        PageInfo<Dailyuse> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public Dailyuseadv Selectdailyuseid(Integer id) {
            return dailyusedao.Selectdailyid(id);

    }

    public Dailyuse updatedailyuseid(Integer id) {
        return dailyusedao.updatedailyuseid(id);
    }

    public void updatedailyuse(Dailyuse dailyuse) {
        dailyusedao.updatedailyuse(dailyuse);
    }

    public void dailyusesave(Dailyuse dailyuse) {
        dailyusedao.dailyusesave(dailyuse);
    }

    public void deletedailyuse(Integer id) {
        dailyusedao.deletedailyuse(id);
    }

    public PageInfo<Dailyuse> shoppingcar1(Dailyuse dailyuse) {
        PageHelper.startPage(dailyuse.getPageNum(), dailyuse.getPageSize());
        List<Dailyuse> list =  dailyusedao.shoppingcar1(dailyuse);//分页查询后的数据
        System.out.println(list);
        PageInfo<Dailyuse> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public PageInfo<Dailyuse> shoppingcar6(Dailyuse dailyuse) {
        PageHelper.startPage(dailyuse.getPageNum(), dailyuse.getPageSize());
        List<Dailyuse> list =  dailyusedao.shoppingcar6(dailyuse);//分页查询后的数据
        System.out.println(list);
        PageInfo<Dailyuse> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    public void deleteshopcar1(Integer id) {
        dailyusedao.deleteshopcar1(id);
    }
}
