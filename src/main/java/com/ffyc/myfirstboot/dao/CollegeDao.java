package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.College;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeDao {

    List<College> getColleges();
}
