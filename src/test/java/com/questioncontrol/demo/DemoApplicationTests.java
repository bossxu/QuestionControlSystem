package com.questioncontrol.demo;

import com.questioncontrol.demo.Dao.QuestionDAtaReponsitory;
import com.questioncontrol.demo.Dao.QuestionTagReponsitory;
import com.questioncontrol.demo.Dao.UserReponsitory;
import com.questioncontrol.demo.Dto.QuestionData;
import com.questioncontrol.demo.Dto.QuestionTag;
import com.questioncontrol.demo.Dto.User;

import com.questioncontrol.demo.Service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserService userServiceiml;

    @Test
    public void contextLoads() throws Exception{

        List<User> userList = userServiceiml.getAlluser();
        JSONArray userjson = new JSONArray(userList.toString());
        System.out.println(userjson);
    }

}
