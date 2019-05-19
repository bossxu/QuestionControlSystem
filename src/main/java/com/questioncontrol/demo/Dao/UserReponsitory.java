package com.questioncontrol.demo.Dao;

import com.questioncontrol.demo.Dto.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserReponsitory extends CrudRepository<User,Integer> {

    public boolean existsByUsername(String Username);

    public User findByUsername(String username);




}
