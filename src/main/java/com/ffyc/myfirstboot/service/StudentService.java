package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.StudentDao;
import com.ffyc.myfirstboot.model.Appointment;
import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.model.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    StudentDao studentDao;

    public PageInfo<Student> search(Student student) {
        PageHelper.startPage(student.getPageNum(), student.getPageSize());
        List<Student> list=  studentDao.search(student);
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    public void save(Student student) {
        //1.密码初始化，加密
        String  password= DigestUtils.md5Hex("111111");
        student.setPassword(password);
        studentDao.save(student);
    }
    public Integer changeCode(Student student) {
        String  passwordjm= DigestUtils.md5Hex(student.getPassword1());//原密码加密比较
        String origin=studentDao.searchCode(student.getId());
        if(passwordjm.equals(origin)){
            studentDao.changeCode(DigestUtils.md5Hex(student.getPassword()),student.getId());
            return 1;
        }else{
            return 0;
        }
    }

    public Student updateStudent(Integer id) {
        return  studentDao.updateStudent(id);
    }

    public void updateStudentSave(Student student) {
        studentDao.updateStudentSave(student);
    }

    public void resetPassword(Integer id) {
        //密码重置111111，加密
        String  password= DigestUtils.md5Hex("111111");
        studentDao.resetPassword(id,password);
    }

    public void delete(Integer id) {
        studentDao.delete(id);
    }
}
