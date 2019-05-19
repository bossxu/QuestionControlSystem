package com.questioncontrol.demo.Service;

import com.questioncontrol.demo.Dto.User;

import java.util.List;

public interface UserService {

    void create(User persion);

    void delete(int id);

    boolean UsernameExist(String username);

    User GetUser(String username);

    List<User> getAlluser();

    void changeTouadmin(String username);

    int GetuserId(String username);


}
