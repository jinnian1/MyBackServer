package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.CollegeDao;
import com.ffyc.myfirstboot.model.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Deevan
 */
@Service
@Transactional
public class CollegeService {
    @Autowired
    CollegeDao collegeDao;

    public List<College> getColleges() {
        return collegeDao.getColleges();
    }
}
