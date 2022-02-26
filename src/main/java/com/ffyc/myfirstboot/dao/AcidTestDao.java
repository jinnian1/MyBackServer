package com.ffyc.myfirstboot.dao;
import com.ffyc.myfirstboot.model.AcidTest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Deevan
 */
@Repository
public interface AcidTestDao {


    void addAcidTest(AcidTest acidTest);

    void deleteAcidTest(@Param("acidTestId") Integer acidTestId);

    AcidTest getAcidTestById(@Param("acidTestId")Integer acidTestId);

    void updateAcidTest(AcidTest acidTest);

    List<AcidTest> getAcidTestList(AcidTest acidTest);
}
