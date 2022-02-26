package com.ffyc.myfirstboot.dao;

import com.ffyc.myfirstboot.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    List<Role> roleList(Role role);
}
