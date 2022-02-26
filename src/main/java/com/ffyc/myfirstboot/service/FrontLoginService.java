package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.FrontLoginDao;
import com.ffyc.myfirstboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrontLoginService {
    @Autowired
    FrontLoginDao frontLoginDao;

    public Student login(Student student) {
      return    frontLoginDao.login(student);
    }
}
