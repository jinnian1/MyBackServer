package com.ffyc.myfirstboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public void save1() {
        jdbcTemplate.update("insert into menu(name,url)values('用户管理','1')");
    }
    public void save2() {
        jdbcTemplate.update("insert into menu(name,url)values('评论管理','1')");
    }
}
