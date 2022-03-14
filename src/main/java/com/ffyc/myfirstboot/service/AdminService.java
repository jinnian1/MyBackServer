package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.ManageDao;
import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.model.Menu;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService {
   @Autowired
   ManageDao manageDao;


    public Manage login(Manage manage) {
        //密码加密与数据库比较
        String  password= DigestUtils.md5Hex(manage.getPassword());
        manage.setPassword(password);
        return manageDao.login(manage);
    }

    public List<Menu> menuList(Integer type, Integer id) {
        Manage manage=new Manage();
        manage.setId(id);
        manage.setType(type);
        return   manageDao.menuList(manage);
    }
}
