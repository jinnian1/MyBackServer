package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Breakdownfix;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixDao {
    List<Breakdownfix> getBreakDownFix();

    void submitFix(Breakdownfix breakdownfix);

    void submitFeedBack(Breakdownfix breakdownfix);

    void deleteBreakDownFix(Integer id);
}
