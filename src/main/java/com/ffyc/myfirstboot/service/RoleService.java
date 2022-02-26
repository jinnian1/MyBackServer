package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.RoleDao;
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
}
