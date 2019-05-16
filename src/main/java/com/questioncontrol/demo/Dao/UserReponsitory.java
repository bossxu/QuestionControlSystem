package com.questioncontrol.demo.Dao;

import com.questioncontrol.demo.Dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserReponsitory extends CrudRepository<User,Long> {

    public boolean existsByUsername(String Username);

    public User findByUsername(String username);

}
