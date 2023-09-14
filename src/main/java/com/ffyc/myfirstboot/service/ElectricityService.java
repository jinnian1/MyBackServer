package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.ElectricityDao;
import com.ffyc.myfirstboot.dao.RoomDao;
import com.ffyc.myfirstboot.model.*;
import javafx.scene.input.DataFormat;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ElectricityService {
   @Autowired
   ElectricityDao electricityDao;
   @Autowired
    RoomDao roomDao;

   public List<Electricity> electricityMessage(Integer studentId) {
      return electricityDao.electricityMessage(studentId);
   }
    public List<Electricity> getBillingInfoList(Student student) {
        return electricityDao.getBillingInfoList(student);
    }

    public Map<String, List> getReportEle() {
        Map<String, List> map = new HashMap<>();
        List<String> dateList = electricityDao.dateList();
        List<Integer> electricityList = electricityDao.electricityList();
        map.put("x", dateList);
        map.put("y", electricityList);
        return map;
    }

    public Map<String, List> reportEle(Integer studentID) {
        Map<String, List> map = new HashMap<>();
        Room room=roomDao.getStudentRoom(studentID);
        System.out.println(room.getNumber());
        List<String> dateList = electricityDao.finddate(room.getNumber());
        List<String> countList = electricityDao.findmoney(room.getNumber());
        map.put("x",countList );
        map.put("y", dateList);
        return map;
    }

    public void billingInfoSave(Electricity electricity) {
        electricityDao.billingInfoSave(electricity);

    }

    public void updateBillingInfo(Electricity electricity) {
        electricityDao.updateBillingInfo(electricity);
        System.out.println("romm何文强"+electricity);
        roomDao.billingInfoSave(electricity);

    }

    public void deleteBillingInfo(Integer id) {
        electricityDao.deleteBillingInfo(id);
    }

    public List<Room> getBillStatisticsList() {
       return electricityDao.getBillStatisticsList();
    }

    public BillingInfo getTotalBill() {
       return electricityDao.getTotalBill();
    }
}
