package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Menu;
import com.ffyc.myfirstboot.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    List<Role> roleList(Role role);

    List<Menu> menuList();

    void save(Role role);

    void saveRelation(@Param("roleid")Integer id, @Param("menuid")Integer integer);

    void delete(Role role);

    Role updateRole(Integer id);

    void updateSave(Role role);

    void deleteRealation(Role role);

    void deleteManageRole(Role role);

    void deleteRoleMenu(Role role);
}
