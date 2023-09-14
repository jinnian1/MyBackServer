package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Electricity;
import com.ffyc.myfirstboot.model.Room;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Deevan
 */
@Repository
public interface RoomDao {

    void addRoom(Room room);

    void deleteRoom(@Param("roomId") Integer roomId);

    Room getRoomById(@Param("roomId")Integer roomId);

    void updateRoom(Room room);

    List<Room> getRoomList(Room room);

    Integer getFloorsBybuildingId(@Param("buildingId") Integer buildingId);

    List<Room> getregiestRoom(@Param("buildingId")Integer buildingId,@Param("height")Integer height);

    Room getStudentRoom(Integer studentID);

    void billingInfoSave(Electricity electricity);
}
