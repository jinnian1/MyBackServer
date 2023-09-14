package com.ffyc.myfirstboot.controller;


import com.ffyc.myfirstboot.model.Building;
import com.ffyc.myfirstboot.model.Student;
import com.ffyc.myfirstboot.service.StudentService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping("/getStudent{studentID}")
    public CommonResult getStudent(@PathVariable("studentID")Integer studentID){
        try {
            Student students=studentService.getStudent(studentID);
            System.out.println(students);
            return new CommonResult(200, "查询成功",  students);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查询失败", null);
        }
    }




    @RequestMapping("/getStudentList")
    public CommonResult<List<Student>> getStudentList(@RequestBody Student student){
        try {
            PageInfo<Student> studentPageInfo = studentService.getStudentList(student);

            return new CommonResult(200, "查询成功",studentPageInfo.getList(), studentPageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查询失败", null);
        }
    }


    @RequestMapping("/getMyInfo{StudentID}")
    public CommonResult getMyInfo(@PathVariable Integer StudentID){
        try {
            Student student = studentService.getMyInfo(StudentID);

            return new CommonResult(200, "查询成功",student);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查询失败", null);
        }
    }

    @RequestMapping("/updateMyInfo")
    public CommonResult updateMyInfo(@RequestBody Student student){
        try {
             studentService.updateMyInfo(student);
            return new CommonResult(200, "修改成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "修改失败", null);
        }
    }
    @RequestMapping("/save")
    public CommonResult save(@RequestBody Student student){
        try {
            System.out.println(student);
            studentService.save(student);
            return new CommonResult(200, "修改成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "修改失败", null);
        }
    }
    @RequestMapping(value ="/updateStudentSave")
    public CommonResult updateStudentSave(@RequestBody Student student) {
        try {
            System.out.println("updateStudentSave----"+student);
            studentService.updateStudentSave(student);
            return new CommonResult(200, "更新成功",  student);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "查找失败", null);
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

    /*密码重置*/
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
    @RequestMapping(value ="/delete/{id}")
    public CommonResult delete(@PathVariable("id")Integer id) {
        try {
            studentService.delete(id);
            return new CommonResult(200, "删除成功",  null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300, "删除失败", null);
        }
    }

    /*修改密码*/
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
    @RequestMapping("/verifycode/{email}")
    public CommonResult verifyCode(@PathVariable("email")String email){
        try {
            Integer i=studentService.verifyCode(email);
            if(i==202){
                return new CommonResult(202,"该邮箱没有对应的账号,请检查邮箱是否正确",null);
            }
            else if (i==201){
                return new CommonResult(201,"五分钟内不得重复发送验证码",null);
            }else{
                return new CommonResult(200,"验证码发送成功,注意五分钟有效期",null);
            }
        } catch (MailException e) {
            e.printStackTrace();
            return new CommonResult(300,"验证码发送失败,服务器忙",null);
        }
    }
    @RequestMapping("/wjCode")
    public CommonResult wjCode(@RequestBody Student student){
        try {
            int flag=studentService.wjCode(student);
            if(flag==1){
                return new CommonResult(200,"重置密码成功,重置密码为111111",null);
            }else if(flag==2){
                return new CommonResult(201,"验证码输入错误,请重试",null);
            }else{
                return new CommonResult(202,"验证码已过期",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(300,"服务器忙",null);
        }
    }

}
