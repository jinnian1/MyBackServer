package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.StudentDao;
import com.ffyc.myfirstboot.model.Building;
import com.ffyc.myfirstboot.model.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    RedisTemplate redisTemplate;

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
    public Integer verifyCode(String email) {
        int emailCheck=studentDao.emailCheck(email);
        if(emailCheck==0){
            return 202;
        }else{
            if (redisTemplate.hasKey(email)){
                return 201;
            }else {
                // 构建一个邮件对象
                SimpleMailMessage message = new SimpleMailMessage();
                // 设置邮件主题
                message.setSubject("用电管理系统重置密码,请注意查收");
                // 设置邮件发送者，这个跟application.yml中设置的要一致
                message.setFrom("1982128184@qq.com");
                // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
                // message.setTo("10*****16@qq.com","12****32*qq.com");
                Random random = new Random();
                int verify = random.nextInt(9000) + 1000;
                ValueOperations valueOperations = redisTemplate.opsForValue();
                valueOperations.set(email, verify, 300 * 1000, TimeUnit.MILLISECONDS);
                message.setTo(email);
                // 设置邮件抄送人，可以有多个抄送人
                //message.setCc("12****32*qq.com");
                // 设置隐秘抄送人，可以有多个
                //message.setBcc("7******9@qq.com");
                // 设置邮件发送日期
                message.setSentDate(new Date());
                // 设置邮件的正文
                message.setText("你的验证码为:" + verify + ",注意有效期为5分钟");
                // 发送邮件
                javaMailSender.send(message);
                return 200;
            }
        }
    }
    public int wjCode(Student student) {
        Integer verify = (Integer) redisTemplate.opsForValue().get(student.getEmail());
        if (redisTemplate.hasKey(student.getEmail())){
            if(verify.equals(student.getVerifycode())){
                student.setPassword("96e79218965eb72c92a549dd5a330112");
                studentDao.wjCode(student);
                redisTemplate.delete(student.getEmail());
                return  1;
            }else{
                return 2;
            }
        }else{
            return 3;
        }
    }

    public Student getStudent(Integer studentID) {
        return studentDao.getStudent(studentID);
    }



    public PageInfo<Student> getStudentList(Student student) {
        PageHelper.startPage(student.getPageNum(), student.getPageSize());
        List<Student> list = studentDao.getStudentList(student);
        return new PageInfo<>(list);
    }

    public Student getMyInfo(Integer StudentID) {
        return studentDao.getMyInfo(StudentID);
    }

    public void updateMyInfo(Student student) {
        studentDao.updateMyInfo(student);
    }
}
