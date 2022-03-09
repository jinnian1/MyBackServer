package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.VolunteerDao;
import com.ffyc.myfirstboot.model.Volunteer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Deevan
 */
@Service
public class VolunteerService {

    @Autowired
    VolunteerDao volunteerDao;

    public void addVolunteer(Volunteer volunteer) {
        volunteer.setState(1);
        volunteer.setHealth("健康");
        volunteerDao.addVolunteer(volunteer);
    }

    public void deleteVolunteer(Integer volunteerId) {
        volunteerDao.deleteVolunteer(volunteerId);
    }

    public Volunteer updateGet(Integer volunteerId) {
        return volunteerDao.getVolunteerById(volunteerId);
    }

    public void updateVolunteer(Volunteer volunteer) {
        volunteerDao.updateVolunteer(volunteer);
    }

    public PageInfo<Volunteer> getVolunteerList(Volunteer volunteer) {
        PageHelper.startPage(volunteer.getPageNum(), volunteer.getPageSize());
        List<Volunteer> list = volunteerDao.getVolunteerList(volunteer);
        return new PageInfo<>(list);
    }

    public Integer isVolunteer(Integer studentId) {
        return volunteerDao.isVolunteer(studentId);
    }

    public Volunteer getVolunteer(Integer studentId) {
        return volunteerDao.getVolunteer(studentId);
    }

    public void changeState(Integer studentId, Integer state) {
        volunteerDao.changeState(studentId,state);
    }
}
