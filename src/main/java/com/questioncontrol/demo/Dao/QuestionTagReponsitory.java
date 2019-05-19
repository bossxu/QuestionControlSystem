package com.questioncontrol.demo.Dao;

import com.questioncontrol.demo.Dto.QuestionTag;
import org.springframework.data.repository.CrudRepository;

public interface QuestionTagReponsitory extends CrudRepository<QuestionTag,Integer> {

    QuestionTag findByTagname(String tagname);

    boolean existsByTagname(String tagname);
}
