package com.ffyc.myfirstboot.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ffyc.myfirstboot.model.Room;
import com.ffyc.myfirstboot.service.RoomService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.TokenUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deevan
 */
@RestController
@RequestMapping("api/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @RequestMapping("addRoom")
    public CommonResult addRoom(@RequestBody Room room) {
        CommonResult commonResult = null;

        roomService.addRoom(room);
        try {
            commonResult = new CommonResult<>(200, "保存成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("deleteRoom/{roomId}")
    public CommonResult deleteRoom(@PathVariable("roomId") Integer roomId) {
        CommonResult commonResult = null;
        roomService.deleteRoom(roomId);
        try {
            commonResult = new CommonResult<>(200, "删除成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("updateGet/{roomId}")
    public CommonResult<Room> updateGet(@PathVariable("roomId") Integer roomId) {
        CommonResult<Room> commonResult = null;
        Room room = roomService.updateGet(roomId);
        try {
            commonResult = new CommonResult<>(200, "查找成功", room);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("updateRoom")
    public CommonResult  updateRoom(@RequestBody Room room) {
        CommonResult commonResult = null;

        roomService.updateRoom(room);
        try {
            commonResult = new CommonResult<>(200, "修改成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("getRoomList")
    public CommonResult<List<Room>> getRoomList(@RequestBody Room room){
        CommonResult commonResult = null;
        try {
            System.out.println(room);
            PageInfo<Room> roomPageInfo = roomService.getRoomList(room);
            commonResult = new CommonResult<>(200, "查询成功", roomPageInfo.getList(), roomPageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "查询失败", null);
        }
        return commonResult;
    }

    @RequestMapping("getFloorsBybuildingId/{buildingId}")
    public CommonResult<List<Integer>> getFloorsByHeight(@PathVariable("buildingId")Integer buildingId){
        CommonResult commonResult = null;
        List<Integer> list = roomService.getFloorsBybuildingId(buildingId);
        try {
            commonResult = new CommonResult<>(200, "查询成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "查询失败", null);
        }
        return commonResult;
    }

    @RequestMapping("getregiestRoom/{buildingId}/{height}")
    public CommonResult  getregiestRoom(@PathVariable("buildingId")Integer buildingId,@PathVariable("height")Integer height){
        try {
            List<Room>list= roomService.getregiestRoom(buildingId,height);
            return  new CommonResult(200,"查找成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(500,"查找失败",null);
        }
    }



    @RequestMapping("getFloorsByBuildingId/{buildingId}")
    public CommonResult<List<Integer>> getFloorsByBuildingId(@PathVariable("buildingId")Integer buildingId) {
        CommonResult commonResult = null;
        System.out.println("888-hewenq");
        List<Integer> list = roomService.getFloorsBybuildingId(buildingId);
        try {
            commonResult = new CommonResult<>(200, "查询成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "查询失败", null);
        }
        return commonResult;
    }


}
