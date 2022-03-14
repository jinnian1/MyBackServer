package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao {
    List<Task> getTaskList(Task task);

    void deleteTask(@Param("id") Integer id);

    List<Building> getBuildings();

    List<Express> expressList(Task task);

    void creatTask(Task task);

    void insertTaskExpress(@Param("taskId")Integer taskId, @Param("expressId")Integer expressId);

    void updateExpressState(@Param("id")Integer id);

    void updateExpressStateByTaskId(@Param("id")Integer id);

    void deleteTaskExpressByTaskId(@Param("taskId")Integer taskId);

    Integer getTypeById(@Param("id")Integer id);

    List<Express> getExpressByTask(@Param("taskId")Integer taskId);

    List<Food> getFoodList(Task task);

    void insertTaskFood(@Param("taskId")Integer taskId,@Param("foodId") Integer foodId);

    void updateTaskState(@Param("id")Integer id);

    List<Food> getFoodByTask(@Param("taskId")Integer taskId);

    void updateFoodStateByTaskId(@Param("taskId")Integer id);

    void deleteTaskFoodByTaskId(@Param("taskId")Integer id);

    List<Dailyuse> getDailyList(Task task);

    void insertTaskDaily(@Param("taskId")Integer taskId, @Param("dailyId")Integer dailyId);

    void updateDailyState(@Param("dailyId")Integer dailyId);

    List<Dailyuse> getDailyByTask(@Param("taskId")Integer taskId);

    void updateDailyStateByTaskId(@Param("taskId")Integer taskId);

    void deleteTaskDailyByTaskId(@Param("taskId")Integer id);

    void acceptTask(@Param("studentID") Integer studentID, @Param("taskId")Integer taskId);

    void updateTaskAccept(@Param("taskId")Integer taskId);

    void overTask(@Param("studentID")Integer studentID, @Param("taskId")Integer taskId);
}
