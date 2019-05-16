package com.questioncontrol.demo.Dao;

import com.questioncontrol.demo.Dto.QuestionData;
import com.questioncontrol.demo.Dto.User;
import org.springframework.data.repository.CrudRepository;

public interface QuestionDAtaReponsitory extends CrudRepository<QuestionData,Integer> {

}
