package com.ffyc.myfirstboot.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ffyc.myfirstboot.model.*;
import com.ffyc.myfirstboot.service.TaskService;
import com.ffyc.myfirstboot.util.CommonResult;
import com.ffyc.myfirstboot.util.TokenUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping("getTaskList")
    public CommonResult<List<Task>> getTaskList(@RequestBody Task task) {
        CommonResult<List<Task>> commonResult = null;
        try {
            PageInfo<Task> taskPageInfo = taskService.getTaskList(task);
            commonResult = new CommonResult<>(200, "查询成功", taskPageInfo.getList(), taskPageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("deleteTask/{id}")
    public CommonResult deleteTask(@PathVariable("id") Integer id) {
        CommonResult commonResult = null;
        try {
            taskService.deleteTask(id);
            commonResult = new CommonResult<>(200, "删除成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("getBuildings")
    public CommonResult<List<Building>> getBuildings() {
        CommonResult<List<Building>> commonResult = null;
        try {
            List<Building> buildings = taskService.getBuildings();
            commonResult = new CommonResult<>(200, "查询成功", buildings);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("getExpressList")
    public CommonResult getExpressList(@RequestBody Task task) {
        CommonResult commonResult = null;
        try {
            PageInfo<Express> pageInfo = taskService.getExpressList(task);
            commonResult = new CommonResult<>(200, "查询成功", pageInfo.getList(), pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("addToExpressTask/{ids}/{buildingId}")
    public CommonResult addToExpressTask(@PathVariable("ids") Integer[] ids, @PathVariable("buildingId") Integer endId, @RequestHeader("token") String token) {
        CommonResult commonResult = null;
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer adminId = tokenInfo.getClaim("id").asInt();
        System.out.println(Arrays.toString(ids));
        try {
            taskService.addToExpressTask(ids, adminId, endId);
            commonResult = new CommonResult<>(200, "添加成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "添加失败，服务器忙或者有用户取消订单", null);
        }
        return commonResult;
    }

    @RequestMapping("getExpressByTask/{id}")
    public CommonResult getExpressByTask(@PathVariable("id") Integer taskId) {
        CommonResult commonResult = null;
        try {
            List<Express> list = taskService.getExpressByTask(taskId);
            commonResult = new CommonResult<>(200, "查询成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("getFoodList")
    public CommonResult getFoodList(@RequestBody Task task) {
        CommonResult commonResult = null;
        try {
            PageInfo<Food> pageInfo = taskService.getFoodList(task);
            commonResult = new CommonResult<>(200, "查询成功", pageInfo.getList(), pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("addToFoodTask/{ids}/{rest}/{buildingId}")
    public CommonResult addToFoodTask(@PathVariable("ids") Integer[] ids, @PathVariable("rest") String rest, @PathVariable("buildingId") Integer endId, @RequestHeader("token") String token) {
        CommonResult commonResult = null;
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer adminId = tokenInfo.getClaim("id").asInt();
        try {
            taskService.addToFoodTask(ids, adminId, rest, endId);
            commonResult = new CommonResult<>(200, "添加成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "添加失败，服务器忙或者有用户取消订单", null);
        }
        return commonResult;
    }

    @RequestMapping("getFoodByTask/{id}")
    public CommonResult getFoodByTask(@PathVariable("id") Integer taskId) {
        CommonResult commonResult = null;
        try {
            List<Food> list = taskService.getFoodByTask(taskId);
            commonResult = new CommonResult<>(200, "查询成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("getDailyList")
    public CommonResult getDailyList(@RequestBody Task task) {
        CommonResult commonResult = null;
        try {
            PageInfo<Dailyuse> pageInfo = taskService.getDailyList(task);
            commonResult = new CommonResult<>(200, "查询成功", pageInfo.getList(), pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("addToDailyTask/{ids}/{buildingId}")
    public CommonResult addToDailyTask(@PathVariable("ids") Integer[] ids, @PathVariable("buildingId") Integer endId, @RequestHeader("token") String token) {
        CommonResult commonResult = null;
        DecodedJWT tokenInfo = TokenUtil.getTokenInfo(token);
        Integer adminId = tokenInfo.getClaim("id").asInt();
        try {
            taskService.addToDailyTask(ids, adminId, endId);
            commonResult = new CommonResult<>(200, "添加成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "添加失败，服务器忙或者有用户取消订单", null);
        }
        return commonResult;
    }

    @RequestMapping("getDailyByTask/{id}")
    public CommonResult getDailyByTask(@PathVariable("id") Integer taskId) {
        CommonResult commonResult = null;
        try {
            List<Dailyuse> list = taskService.getDailyByTask(taskId);
            commonResult = new CommonResult<>(200, "查询成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("acceptTask/{studentID}/{taskId}")
    public CommonResult acceptTask(@PathVariable("studentID") Integer studentID,@PathVariable("taskId") Integer taskId) {
        CommonResult commonResult = null;
        try {
            taskService.acceptTask(studentID,taskId);
            commonResult = new CommonResult<>(200, "操作成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("deleteAccept/{taskId}")
    public CommonResult deleteAccept(@PathVariable("taskId") Integer taskId) {
        CommonResult commonResult = null;
        try {
            taskService.deleteAccept(taskId);
            commonResult = new CommonResult<>(200, "操作成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }

    @RequestMapping("overTask/{studentID}/{taskId}")
    public CommonResult overTask(@PathVariable("studentID") Integer studentID,@PathVariable("taskId") Integer taskId) {
        CommonResult commonResult = null;
        try {
            taskService.overTask(studentID,taskId);
            commonResult = new CommonResult<>(200, "操作成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult<>(500, "服务器忙", null);
        }
        return commonResult;
    }
}
