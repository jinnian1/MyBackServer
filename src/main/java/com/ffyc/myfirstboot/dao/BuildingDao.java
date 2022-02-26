package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Building;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingDao {

    void addBuilding(Building building);

    void deleteBuilding(@Param("buildingId") Integer buildingId);

    Building getBuildingById(@Param("buildingId") Integer buildingId);

    void updateBuilding(Building building);

    List<Building> getBuildingList(Building building);
}
