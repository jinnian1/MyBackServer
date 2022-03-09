package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Volunteer;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Deevan
 */
@Repository
public interface VolunteerDao {

    void addVolunteer(Volunteer volunteer);

    void deleteVolunteer(@Param("volunteerId") Integer volunteerId);

    Volunteer getVolunteerById(@Param("volunteerId")Integer volunteerId);

    void updateVolunteer(Volunteer volunteer);

    List<Volunteer> getVolunteerList(Volunteer volunteer);

    Integer isVolunteer(@Param("studentId")Integer studentId);

    Volunteer getVolunteer(@Param("studentId")Integer studentId);

    void changeState(@Param("studentId")Integer studentId, @Param("state")Integer state);
}
