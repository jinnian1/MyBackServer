package com.ffyc.myfirstboot.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ffyc.myfirstboot.model.Building;
import com.ffyc.myfirstboot.service.BuildingService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.TokenUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Deevan
 */
@RestController
@RequestMapping("api/building")
public class BuildingController {

    @Autowired
    BuildingService buildingService;

    @RequestMapping("addBuilding")
    public CommonResult addBuilding(@RequestBody Building building) {
        CommonResult commonResult = null;
        //拿到管理员id
        buildingService.addBuilding(building);
        try {
            commonResult = new CommonResult<>(200, "保存成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("deleteBuilding/{buildingId}")
    public CommonResult deleteBuilding(@PathVariable("buildingId") Integer buildingId) {
        CommonResult commonResult = null;

            buildingService.deleteBuilding(buildingId);
            try {
                commonResult = new CommonResult<>(200, "删除成功", null);
            } catch (Exception e) {
                e.printStackTrace();
                commonResult = new CommonResult<>(500, "服务器忙", null);
            }
        return commonResult;
    }

    @RequestMapping("updateGet/{buildingId}")
    public CommonResult<Building> updateGet(@PathVariable("buildingId") Integer buildingId) {
        CommonResult<Building> commonResult = null;
        Building building = buildingService.updateGet(buildingId);
        try {
            commonResult = new CommonResult<>(200, "查找成功", building);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("updateBuilding")
    public CommonResult updateBuilding(@RequestHeader("token") String token, @RequestBody Building building) {
        CommonResult commonResult = null;
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer manageId = tokenInfo.getClaim("id").asInt();
        building.setOperator(manageId);
        buildingService.updateBuilding(building);
        try {
            commonResult = new CommonResult<>(200, "修改成功", building);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("getBuildingList")
    public CommonResult<List<Building>> getBuildingList(@RequestBody Building building) {
        CommonResult commonResult = null;
        try {
            System.out.println("何文强");
            PageInfo<Building> buildingPageInfo = buildingService.getBuildingList(building);
            commonResult = new CommonResult<>(200, "查询成功", buildingPageInfo.getList(), buildingPageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "查询失败", null);
        }
        return commonResult;
    }


}
