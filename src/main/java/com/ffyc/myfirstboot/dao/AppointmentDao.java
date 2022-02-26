package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Appointment;
import com.ffyc.myfirstboot.model.Express;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentDao {
    List<Appointment> appointmentList(Appointment appointment);

    List<Appointment> appointmentListOver(Appointment appointment);
}
