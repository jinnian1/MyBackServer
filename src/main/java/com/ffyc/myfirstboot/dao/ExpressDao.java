package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Express;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpressDao {
    List<Express>expressList(Express express);

    void delete(int id);

    void save(Express express);

    Integer searchID(String sno);
}