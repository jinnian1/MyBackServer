package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.TaskDao;
import com.ffyc.myfirstboot.model.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author Deevan
 */
@Service
@Transactional
public class TaskService {
    @Autowired
    TaskDao taskDao;

    public PageInfo<Task> getTaskList(Task task) {
        PageHelper.startPage(task.getPageNum(), task.getPageSize());
        List<Task> list = taskDao.getTaskList(task);
        return new PageInfo<>(list);
    }

    public void deleteTask(Integer id) {
        //获取任务类型
        Integer type = taskDao.getTypeById(id);
        if (type == 3) {
            //修改任务状态为未配送
            taskDao.updateExpressStateByTaskId(id);
            //删除任务订单关系
            taskDao.deleteTaskExpressByTaskId(id);
        } else if (type == 1) {
            taskDao.updateFoodStateByTaskId(id);
            taskDao.deleteTaskFoodByTaskId(id);
        } else if (type == 2) {
            taskDao.updateDailyStateByTaskId(id);
            taskDao.deleteTaskDailyByTaskId(id);
        }
        //删除任务
        taskDao.deleteTask(id);
    }

    public List<Building> getBuildings() {
        return taskDao.getBuildings();
    }

    public PageInfo<Express> getExpressList(Task task) {
        PageHelper.startPage(task.getPageNum(), task.getPageSize());
        List<Express> list = taskDao.expressList(task);
        return new PageInfo<>(list);
    }

    public void addToExpressTask(Integer[] ids, Integer adminId, Integer endId) {
        //创建一个任务,返回任务主键id
        Task task = new Task();
        task.setType(3);//快递
        task.setStart(7);//快递群
        task.setEnd(endId);//送至楼栋
        task.setOperator(adminId);
        taskDao.creatTask(task);
        Integer taskId = task.getId();

        for (int i = 0; i < ids.length - 1; i++) {
            //添加 任务—快递订单 关系
            taskDao.insertTaskExpress(taskId, ids[i]);
            //把这些订单的状态都改为配送中
            taskDao.updateExpressState(ids[i]);
        }
    }

    public List<Express> getExpressByTask(Integer taskId) {
        return taskDao.getExpressByTask(taskId);
    }

    public PageInfo<Food> getFoodList(Task task) {
        PageHelper.startPage(task.getPageNum(), task.getPageSize());
        List<Food> list = taskDao.getFoodList(task);
        return new PageInfo<>(list);
    }

    public void addToFoodTask(Integer[] ids, Integer adminId, String rest, Integer endId) {
        //转换rest为开始楼栋
        int startId = 0;
        if ("厚朴餐厅".equals(rest)) {
            startId = 4;
        } else if ("天汉餐厅".equals(rest)) {
            startId = 5;
        } else if ("汉韵餐厅".equals(rest)) {
            startId = 6;
        }
        //创建一个任务,返回任务主键id
        Task task = new Task();
        task.setType(1);
        task.setStart(startId);
        task.setEnd(endId);
        task.setOperator(adminId);
        taskDao.creatTask(task);
        Integer taskId = task.getId();

        for (int i = 0; i < ids.length - 1; i++) {
            //添加 任务—订餐订单 关系
            System.out.println(Arrays.toString(ids));
            taskDao.insertTaskFood(taskId, ids[i]);
            //把这些订单的状态都改为配送中
            taskDao.updateTaskState(ids[i]);
        }
    }

    public List<Food> getFoodByTask(Integer taskId) {
        return taskDao.getFoodByTask(taskId);
    }

    public PageInfo<Dailyuse> getDailyList(Task task) {
        PageHelper.startPage(task.getPageNum(), task.getPageSize());
        List<Dailyuse> list = taskDao.getDailyList(task);
        return new PageInfo<>(list);
    }

    public void addToDailyTask(Integer[] ids, Integer adminId, Integer endId) {
        //创建一个任务,返回任务主键id
        Task task = new Task();
        task.setType(2);//日用
        task.setStart(8);//超市
        task.setEnd(endId);
        task.setOperator(adminId);
        taskDao.creatTask(task);
        Integer taskId = task.getId();

        for (int i = 0; i < ids.length - 1; i++) {
            //添加 任务—日用订单 关系
            taskDao.insertTaskDaily(taskId, ids[i]);
            //把这些订单的状态都改为配送中
            taskDao.updateDailyState(ids[i]);
        }
    }

    public List<Dailyuse> getDailyByTask(Integer taskId) {
        return taskDao.getDailyByTask(taskId);
    }

    public  synchronized  Integer acceptTask(Integer studentID, Integer taskId) {
        Integer check=taskDao.acceptTaskCheck(taskId);
        if(check.equals(1)){
            //修改该任务状态，添加学生
            taskDao.acceptTask(studentID,taskId);
            return  1;
        }else{
           return  0;
        }
    }

    public void deleteAccept(Integer taskId) {
        taskDao.updateTaskAccept(taskId);
    }

    public void overTask(Integer studentID, Integer taskId) {
        taskDao.overTask(studentID,taskId);
    }
}
