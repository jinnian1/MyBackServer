package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.BillingInfo;
import com.ffyc.myfirstboot.model.Electricity;
import com.ffyc.myfirstboot.model.Room;
import com.ffyc.myfirstboot.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface ElectricityDao {


    List<Electricity> electricityMessage(Integer studentId);

    List<String> dateList();

    List<Integer> electricityList();

    List<Electricity> getBillingInfoList(Student student);


    List<String> finddate(String number);

    List<String> findmoney(String number);

    void billingInfoSave(Electricity electricity);

    void updateBillingInfo(Electricity electricity);

    void deleteBillingInfo(Integer id);

    List<Room> getBillStatisticsList();

    BillingInfo getTotalBill();
}
