package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentDao {
    List<Appointment> appointmentList(Appointment appointment);

    List<Appointment> appointmentListOver(Appointment appointment);

    Appointment updateAppointment(Integer id);

    void updatesaveAppointment(Appointment appointment);

    void delete(Integer id);

    void appointment(Appointment appointment);

    Integer check(Integer studentID);

    Appointment searchTime(Integer psychologistID);

    List<Appointment> centersearch(Appointment appointment);

    Integer checkNum(Integer psychologistID);

    int studelcheck(Integer id);
}
