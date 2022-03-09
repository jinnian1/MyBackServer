package com.ffyc.myfirstboot.dao;

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

    Integer getFloorsByBuildingID(@Param("buildingID") Integer buildingID);

    List<Room> getregiestRoom(@Param("buildingID")Integer buildingID,@Param("height")Integer height);
}
