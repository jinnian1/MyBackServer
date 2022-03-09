package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.RoomDao;
import com.ffyc.myfirstboot.model.Building;
import com.ffyc.myfirstboot.model.Room;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deevan
 */
@Service
@Transactional
public class RoomService {

    @Autowired
    RoomDao roomDao;

    public void addRoom(Room room) {
        roomDao.addRoom(room);
    }

    public void deleteRoom(Integer roomId) {
        roomDao.deleteRoom(roomId);
    }

    public Room updateGet(Integer roomId) {
        return roomDao.getRoomById(roomId);
    }

    public void updateRoom(Room room) {
        roomDao.updateRoom(room);
    }

    public PageInfo<Room> getRoomList(Room room) {
        PageHelper.startPage(room.getPageNum(), room.getPageSize());
        List<Room> list = roomDao.getRoomList(room);
        return new PageInfo<>(list);
    }

    public List<Integer> getFloorsByBuildingID(Integer buildingID) {
        Integer height = roomDao.getFloorsByBuildingID(buildingID);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= height; i++) {
            list.add(i);
        }
        return list;
    }

    public List<Room> getregiestRoom(Integer buildingID, Integer height) {
        return  roomDao.getregiestRoom(buildingID,height);
    }
}
