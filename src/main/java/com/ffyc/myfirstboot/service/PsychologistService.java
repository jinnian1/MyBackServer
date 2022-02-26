package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.PsyDao;
import com.ffyc.myfirstboot.model.Express;
import com.ffyc.myfirstboot.model.Psychologist;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PsychologistService {
    @Autowired
    PsyDao psyDao;

    public PageInfo<Psychologist> psyList(Psychologist psychologist) {
        PageHelper.startPage(psychologist.getPageNum(), psychologist.getPageSize());
        List<Psychologist> list=  psyDao.list(psychologist);
        PageInfo<Psychologist> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    public List<Psychologist> searchdoctor() {
        List<Psychologist> list=  psyDao.searchdoctor();
        return  list;
    }
}
