package com.questioncontrol.demo.Service;

import com.questioncontrol.demo.Dto.User;

public interface UserService {

    void create(String username, String userpwd, int usertype);

    void delete(long id);

    boolean UsernameExist(String username);

    User GetUser(String username);

    int GetUserTtpe(String username);

}
