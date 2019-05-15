package com.questioncontrol.demo.Service.impl;

import com.questioncontrol.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String username, String userpwd) {
        jdbcTemplate.update("insert into User values(?,?) ",username,userpwd);
    }

    @Override
    public void delete(String username) {
        jdbcTemplate.update("delete from User where username = ?",username);
    }


}
