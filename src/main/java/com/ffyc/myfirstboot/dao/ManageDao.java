package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Building;
import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.model.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

@Repository
public interface ManageDao {

    Manage login(Manage manage);

    List<Menu> menuList(Manage manage);

    List<Manage> manageList(Manage manage);

    List<Role> roleList();

    void saveManageRole(Integer id, Integer integer);

    void save(Manage manage);

    Manage updateManage(Integer id);

    void updateManageSave(Manage manage);

    void deleteRelation(Integer id);

    void addRelation(Integer id, Integer integer);

    void deleteManage(Integer id);

    String searchCode(Integer id);

    void changeCode(String password, Integer id);

    void resetPassword(Integer id, String password);

    void register(Manage manage);

    Manage getManageInfo(Integer id);

    void updateManageInfo(Manage manage);
}
