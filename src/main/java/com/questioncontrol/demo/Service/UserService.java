package com.questioncontrol.demo.Service;

import com.questioncontrol.demo.Dto.User;

import java.util.List;

public interface UserService {

    void create(String username, String userpwd, int usertype);

    void delete(long id);

    boolean UsernameExist(String username);

    User GetUser(String username);

    int GetUserTypebyUsername(String username);

    List<User> getAlluser();

    int GetUserTypebyUserid(String id);

}
