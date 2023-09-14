package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.ElectricityDao;
import com.ffyc.myfirstboot.dao.FixDao;
import com.ffyc.myfirstboot.model.Breakdownfix;
import com.ffyc.myfirstboot.model.HorseLamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FixService {
    @Autowired
    FixDao fixDao;

    public List<Breakdownfix> getBreakDownFix() {
        List<Breakdownfix> list = fixDao.getBreakDownFix();
        return list;
    }

    public void submitFix(Breakdownfix breakdownfix) {
        fixDao.submitFix(breakdownfix);
    }

    public void submitFeedBack(Breakdownfix breakdownfix) {
        fixDao.submitFeedBack(breakdownfix);
    }

    public void deleteBreakDownFix(Integer id) {
        fixDao.deleteBreakDownFix(id);
    }
}
