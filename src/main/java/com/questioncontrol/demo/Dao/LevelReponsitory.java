package com.questioncontrol.demo.Dao;

import com.questioncontrol.demo.Dto.Level;
import org.springframework.data.repository.CrudRepository;

public interface LevelReponsitory extends CrudRepository<Level,Integer> {

    boolean existsByLevelName(String levelname);

    Level findByLevelName(String levelname);
}
