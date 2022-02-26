package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.BuildingDao;
import com.ffyc.myfirstboot.model.Building;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BuildingService {

    @Autowired
    BuildingDao buildingDao;

    public void addBuilding(Building building) {
        buildingDao.addBuilding(building);
    }

    public void deleteBuilding(Integer buildingId) {
        buildingDao.deleteBuilding(buildingId);
    }

    public Building updateGet(Integer buildingId) {
        return buildingDao.getBuildingById(buildingId);
    }

    public void updateBuilding(Building building) {
        buildingDao.updateBuilding(building);
    }

    public PageInfo<Building> getBuildingList(Building building) {
        PageHelper.startPage(building.getPageNum(), building.getPageSize());
        List<Building> list = buildingDao.getBuildingList(building);
        return new PageInfo<>(list);
    }
}
