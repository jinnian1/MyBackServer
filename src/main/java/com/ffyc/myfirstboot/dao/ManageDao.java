package com.ffyc.myfirstboot.dao;


import com.ffyc.myfirstboot.model.Manage;
import com.ffyc.myfirstboot.model.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

@Repository
public interface ManageDao {
    Manage login(Manage admin);
    List<Menu> menuList(Manage manage);
    List<Manage> manageList(Manage manage);

    List<Role> roleList();

    void save(Manage manage);

    void saveManageRole(@Param("manageid")Integer id, @Param("roleid")Integer id1);

    Manage updateManage(Integer id);

    void updateManageSave(Manage manage);

    void deleteRelation(Integer id);

    void addRelation(@Param("manageid")Integer id, @Param("roleid")Integer id1);

    void deleteManage(Integer id1);

    String searchCode(Integer id1);

    void changeCode(@Param("mm")String mm1,@Param("id")Integer id);
}
