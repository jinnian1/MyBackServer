package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.RoleDao;
import com.ffyc.myfirstboot.model.Menu;
import com.ffyc.myfirstboot.model.Role;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;
    public PageInfo<Role> search(Role role) {
        PageHelper.startPage(role.getPageNum(), role.getPageSize());
        List<Role> list = roleDao.roleList(role);//分页查询后的数据
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public List<Menu> menuList() {
        List<Menu>menuList=roleDao.menuList();
        return menuList;
    }

    public void save(Role role) {
        //保存角色信息
        roleDao.save(role);
        //保存角色和菜单的关系
        for (int i = 0; i < role.getMenuID().length; i++) {
            roleDao.saveRelation(role.getId(),role.getMenuID()[i]);
        }
    }

    public void delete(Role role) {
        //删除角色和管理员的关系
        roleDao.deleteManageRole(role);
        //删除角色和菜单的关系
        roleDao.deleteRoleMenu(role);
        //删除角色
        roleDao.delete(role);
    }

    public Role update(Integer id){
       Role role= roleDao.updateRole(id);
        Integer[] menuID=new Integer[role.getMenuList().size()];
        for (int i = 0; i < role.getMenuList().size(); i++) {
            menuID[i]=role.getMenuList().get(i).getId();
        }
        role.setMenuID(menuID);
       return role;
    }

    public void updateSave(Role role) {
        //保存角色信息
        roleDao.updateSave(role);
        //删除角色和之前菜单的关系
        roleDao.deleteRealation(role);
        //保存现在的关系
        for (int i = 0; i <role.getMenuID().length ; i++) {
            roleDao.saveRelation(role.getId(),role.getMenuID()[i]);
        }
    }
}
