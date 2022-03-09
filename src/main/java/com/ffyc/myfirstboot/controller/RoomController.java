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
    public CommonResult addRoom(@RequestHeader("token") String token,@RequestBody Room room) {
        CommonResult commonResult = null;
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer manageId = tokenInfo.getClaim("id").asInt();
        room.setOperator(manageId);
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
    public CommonResult  updateRoom(@RequestHeader("token") String token,@RequestBody Room room) {
        CommonResult commonResult = null;
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer manageId = tokenInfo.getClaim("id").asInt();
        room.setOperator(manageId);
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
            PageInfo<Room> roomPageInfo = roomService.getRoomList(room);
            commonResult = new CommonResult<>(200, "查询成功", roomPageInfo.getList(), roomPageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "查询失败", null);
        }
        return commonResult;
    }

    @RequestMapping("getFloorsByBuildingID/{buildingID}")
    public CommonResult<List<Integer>> getFloorsByHeight(@PathVariable("buildingID")Integer buildingID){
        CommonResult commonResult = null;
        List<Integer> list = roomService.getFloorsByBuildingID(buildingID);
        try {
            commonResult = new CommonResult<>(200, "查询成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "查询失败", null);
        }
        return commonResult;
    }

    @RequestMapping("getregiestRoom/{buildingID}/{height}")
    public CommonResult  getregiestRoom(@PathVariable("buildingID")Integer buildingID,@PathVariable("height")Integer height){
        try {
            List<Room>list= roomService.getregiestRoom(buildingID,height);
            return  new CommonResult(200,"查找成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            return  new CommonResult(500,"查找失败",null);
        }
    }
}
