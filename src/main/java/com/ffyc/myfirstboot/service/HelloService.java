package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HelloService {
    @Autowired
    HelloDao helloDao;
    public  void save(){
        helloDao.save1();
        //int a=10/0;
        helloDao.save2();
    }
}
