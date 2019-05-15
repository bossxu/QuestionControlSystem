package com.questioncontrol.demo.Dao;

import com.questioncontrol.demo.Dto.User;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.data.repository.CrudRepository;

public interface UserReponsitory extends CrudRepository<User,Long> {

}
