package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.AppointmentDao;
import com.ffyc.myfirstboot.model.Appointment;
import com.ffyc.myfirstboot.model.Express;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public void appointment(Appointment appointment) {
        appointmentDao.appointment(appointment);
    }

    public Integer check(Integer studentID) {
        return appointmentDao.check(studentID);
    }
}
