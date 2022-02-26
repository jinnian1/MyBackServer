package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.ExpressDao;
import com.ffyc.myfirstboot.model.Express;
import com.ffyc.myfirstboot.model.Manage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class ExpressService {
    @Autowired
    ExpressDao expressDao;

    public PageInfo<Express> expressList(Express express){
        PageHelper.startPage(express.getPageNum(), express.getPageSize());
        List<Express>list=  expressDao.expressList(express);
        PageInfo<Express> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    public void delete(int id) {
        expressDao.delete(id);
    }

    public void save(Express express) {
        Integer id=expressDao.searchID(express.getSno());
        express.setId(id);
        expressDao.save(express);
    }
}
