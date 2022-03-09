package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Express;
import com.ffyc.myfirstboot.model.Psychologist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PsyDao {

    List<Psychologist> searchdoctor();

    void addDoctor(Psychologist psychologist);

    List<Psychologist> list(Psychologist psychologist);

    Psychologist updateDoctor(Integer id);

    void updateDoctorSave(Psychologist psychologist);

    void psychologistDelete(Integer id);
}
