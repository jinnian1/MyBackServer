package com.ffyc.myfirstboot.controller;

import com.ffyc.myfirstboot.model.Appointment;
import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.model.Student;
import com.ffyc.myfirstboot.service.StudentService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Student")
public class ControllerStudent {
    @Autowired
    StudentService studentService;
    @RequestMapping("/search")
    public CommonResult search(@RequestBody Student student){
        try {
            PageInfo<Student> pageInfo = studentService.search(student);
            return new CommonResult(200,"查找成功",pageInfo.getList(),pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300,"查找失败",null);
        }
    }
    @RequestMapping("/save")
    public CommonResult<Student>save(@RequestBody Student student){
        try {
            studentService.save(student);
            return new CommonResult(200,"保存成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300,"保存失败",null);
        }
    }
    @RequestMapping(value ="/changeCode")
    public CommonResult changeCode(@RequestBody Student student) {
        try {
            //检查原密码正确与否,正确保存新密码
            Integer check= studentService.changeCode(student);
            if(check.equals(1)){
                return new CommonResult(200, "修改成功",  null);
            }else{
                return new CommonResult(201, "原密码错误",  null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "修改失败", null);
        }
    }
    @RequestMapping(value ="/updateStudent/{id}")
    public CommonResult updateStudent(@PathVariable("id")Integer id) {
        try {
            Student student=studentService.updateStudent(id);
            return new CommonResult(200, "查找成功",  student);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查找失败", null);
        }
    }
    @RequestMapping(value ="/updateStudentSave")
    public CommonResult updateStudentSave(@RequestBody Student student) {
        try {
           studentService.updateStudentSave(student);
            return new CommonResult(200, "更新成功",  student);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查找失败", null);
        }
    }
    @RequestMapping(value ="/resetPassword/{id}")
    public CommonResult resetPassword(@PathVariable("id")Integer id) {
        try {
            studentService.resetPassword(id);
            return new CommonResult(200, "重置成功",  null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查找失败", null);
        }
    }

}
