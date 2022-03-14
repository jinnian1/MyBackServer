package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.FrontLoginDao;
import com.ffyc.myfirstboot.model.Student;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FrontLoginService {
    @Autowired
    FrontLoginDao frontLoginDao;

    public Student login(Student student) {
        String  password= DigestUtils.md5Hex(student.getPassword());
        student.setPassword(password);
      return    frontLoginDao.login(student);
    }
}
