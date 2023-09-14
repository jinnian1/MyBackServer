package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Building;
import com.ffyc.myfirstboot.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {


    List<Student> search(Student student);

    void save(Student student);

    String searchCode(Integer id);

    void changeCode(@Param("mm")String mm1, @Param("id")Integer id);

    Student updateStudent(Integer id);

    void updateStudentSave(Student student);

    void resetPassword(@Param("id")Integer id,@Param("mm")String password);

    void delete(Integer id);

    void wjCode(Student student);

    int emailCheck(String email);

    Student getStudent(Integer studentID);

    void billingInfoSave(Building building);

    List<Student> getStudentList(Student student);

    Student getMyInfo(Integer studentID);

    void updateMyInfo(Student student);
}
