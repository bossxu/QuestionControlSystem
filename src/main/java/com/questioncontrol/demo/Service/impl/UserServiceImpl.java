package com.questioncontrol.demo.Service.impl;

import com.questioncontrol.demo.Dao.UserReponsitory;
import com.questioncontrol.demo.Dto.User;
import com.questioncontrol.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserReponsitory userReponsitory;


    @Override
    public void create(String username, String userpwd,int usertype) {

        User newUesr = new User();
        newUesr.setUsername(username);
        newUesr.setUserpwd(userpwd);
        newUesr.setUsertype(usertype);
        long a = 0;
        newUesr.setId(a);
        userReponsitory.save(newUesr);

    }

    @Override
    public void delete(long id) {
        userReponsitory.deleteById(id);
    }

    @Override
    public boolean UsernameExist(String username) {
        return userReponsitory.existsByUsername(username);
    }

    @Override
    public User GetUser(String username) {
        User user = userReponsitory.findByUsername(username);
        return user;
    }

    @Override
    public int GetUserTtpe(String username) {
        return GetUser(username).getUsertype();
    }

    @Override
    public List<User> getAlluser() {
        Iterator<User> userIterator = userReponsitory.findAll().iterator();
        List<User> userlist= new ArrayList<>();
        while (userIterator.hasNext())
        {
            userlist.add(userIterator.next());
        }
        return userlist;
    }

}
