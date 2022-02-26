package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface FrontLoginDao {
    Student login(Student student);
}
