package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.AcidTestDao;
import com.ffyc.myfirstboot.model.AcidTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Deevan
 */
@Service
public class AcidTestService {

    @Autowired
    AcidTestDao acidTestDao;

    public void addAcidTest(AcidTest acidTest) {
        acidTestDao.addAcidTest(acidTest);
    }

    public void deleteAcidTest(Integer acidTestId) {
        acidTestDao.deleteAcidTest(acidTestId);
    }

    public AcidTest updateGet(Integer acidTestId) {
        return acidTestDao.getAcidTestById(acidTestId);
    }

    public void updateAcidTest(AcidTest acidTest) {
        acidTestDao.updateAcidTest(acidTest);
    }

    public List<AcidTest> getAcidTestList(AcidTest acidTest) {
        return acidTestDao.getAcidTestList(acidTest);
    }
}
