package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Express;
import com.ffyc.myfirstboot.model.Psychologist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PsyDao {

    List<Psychologist> list(Psychologist psychologist);

    List<Psychologist> searchdoctor();
}
