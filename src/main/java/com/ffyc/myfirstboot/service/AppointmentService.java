package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.AppointmentDao;
import com.ffyc.myfirstboot.model.Appointment;
import com.ffyc.myfirstboot.model.Express;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppointmentService {
    @Autowired
    AppointmentDao appointmentDao;

    public PageInfo<Appointment> appointmentList(Appointment appointment) {
        PageHelper.startPage(appointment.getPageNum(), appointment.getPageSize());
        List<Appointment> list=  appointmentDao.appointmentList(appointment);
        PageInfo<Appointment> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    public PageInfo<Appointment> appointmentListOver(Appointment appointment) {
        PageHelper.startPage(appointment.getPageNum(), appointment.getPageSize());
        List<Appointment> list=  appointmentDao.appointmentListOver(appointment);
        PageInfo<Appointment> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    public Appointment updateAppointment(Integer id) {
        return appointmentDao.updateAppointment(id);
    }

    public void updatesaveAppointment(Appointment appointment) {
        appointmentDao.updatesaveAppointment(appointment);
    }

    public void deleteAppointment(Integer id) {
        appointmentDao.delete(id);
    }

    public  synchronized int appointment(Appointment appointment) {
       int num= appointmentDao.checkNum(appointment.getPsychologistID());
       if(num==10){
            return  0;
       }else{
           Appointment temp= appointmentDao.searchTime(appointment.getPsychologistID());
           appointment.setStarttime(temp.getStarttime());
           appointment.setEndtime(temp.getEndtime());
           appointmentDao.appointment(appointment);
           return 1;
       }
    }

    public Integer check(Integer studentID) {
        return appointmentDao.check(studentID);
    }

    public PageInfo<Appointment> centersearch(Appointment appointment) {
        PageHelper.startPage(appointment.getPageNum(), appointment.getPageSize());
        List<Appointment> list=  appointmentDao.centersearch(appointment);
        PageInfo<Appointment> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    public int studeleteAppointment(Integer id) {
        int check=appointmentDao.studelcheck(id);
        if(check==1){
            //该咨询已经进行,无法删除
            return 0;
        }else{
            //删除该场咨询
            appointmentDao.delete(id);
            return 1;
        }
    }
}
