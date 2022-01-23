package com.ffyc.myfirstboot.service;

import com.ffyc.myfirstboot.dao.ManageDao;
import com.ffyc.myfirstboot.model.Manage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ManageService {
    @Autowired
    ManageDao manageDao;
    @Transactional(propagation = Propagation.REQUIRED)
    public PageInfo<Manage> manageList(Manage manage) {
        PageHelper.startPage(manage.getPageNum(), manage.getPageSize());
        List<Manage> list = manageDao.manageList(manage);//分页查询后的数据
        PageInfo<Manage> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Role> roleList() {
        return manageDao.roleList();
    }



    public void save(Manage manage) {
        //1.密码初始化，加密
        String  password= DigestUtils.md5Hex("111111");
        System.out.println(password);
        manage.setPassword(password);
        //2.保存管理员信息
        manageDao.save(manage);
        //3.保存管理员和角色的关系
        for (int i = 0; i < manage.getRoleId().length; i++) {
            manageDao.saveManageRole(manage.getId(),manage.getRoleId()[i]);
        }
    }

    public Manage updateManage(String id) {
        Integer manageid=new Integer(id);
       return  manageDao.updateManage(manageid);
    }

    public void updateSaveManage(Manage manage) {
        //修改管理员信息
         manageDao.updateManageSave(manage);
        //删除管理员和角色之前的联系
           manageDao.deleteRelation(manage.getId());
        //插入管理员和角色现在的联系
        for (int i = 0; i < manage.getRoleId().length; i++) {
            manageDao.addRelation(manage.getId(),manage.getRoleId()[i]);
        }
    }

    public void deleteManage(String id) {
        Integer id1=new Integer(id);
        manageDao.deleteManage(id1);
    }

}
