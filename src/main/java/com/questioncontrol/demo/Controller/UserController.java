package com.questioncontrol.demo.Controller;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.questioncontrol.demo.Dto.User;
import com.questioncontrol.demo.Service.UserService;
import com.questioncontrol.demo.Service.impl.UserServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "/login")
    public String logincheck(@RequestBody User persion) throws Exception
    {
        JSONObject returnjson = new JSONObject();
        if(!userService.UsernameExist(persion.getUsername()) || !userService.GetUser(persion.getUsername()).getUserpwd().equals(persion.getUserpwd()))
        {
            returnjson.put("state","error");
            returnjson.put("response","登陆出错，用户名不存在或密码错误");
        }
        else
        {
            persion = userService.GetUser(persion.getUsername());
            returnjson.put("state","success");
            returnjson.put("response",new JSONObject(persion.toString()));
        }
        return returnjson.toString();
    }

    @PostMapping(value = "/registe")
    public String regiset(@RequestBody  User persion) throws Exception
    {
        JSONObject returnjson = new JSONObject();
        if(userService.UsernameExist(persion.getUsername()))
        {
            returnjson.put("state","error");
            returnjson.put("response","用户名存在");
        }
        else
        {
            userService.create(persion);
            returnjson.put("state","success");
            returnjson.put("response",new JSONObject(userService.GetUser(persion.getUsername()).toString()));
        }
        System.out.println(returnjson.toString());
        return returnjson.toString();
    }
    @GetMapping(value = "/all")
    public List<User> getalluser()
    {
        return userService.getAlluser();
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteuser(@PathVariable int id)
    {
        try{
            userService.delete(id);
            return "{\"state\":\"SUCCESS\"}";
        }
        catch (Exception e)
        {
            return "{\"state\":\"ERROR\"}";
        }
    }
    @GetMapping(value = "/{id}")
    public User GetUserdetail(@PathVariable int id)
    {
        return userService.GetUserbyid(id);
    }

}
