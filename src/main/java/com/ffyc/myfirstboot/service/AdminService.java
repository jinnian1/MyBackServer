package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.ManageDao;
import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
   @Autowired
   ManageDao manageDao;


    public Manage login(Manage manage) {
        return manageDao.login(manage);
    }

    public List<Menu> menuList(Integer type, Integer id) {
        Manage manage=new Manage();
        manage.setId(id);
        manage.setType(type);
        return   manageDao.menuList(manage);
    }
}
