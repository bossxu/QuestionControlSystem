package com.questioncontrol.demo.Service.impl;

import com.questioncontrol.demo.Dao.UserReponsitory;
import com.questioncontrol.demo.DemoApplication;
import com.questioncontrol.demo.Dto.User;
import com.questioncontrol.demo.Service.UserService;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserReponsitory userReponsitory;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws Exception
    {
        userReponsitory.save(new User("langman","1998129"));
    }
}