package com.questioncontrol.demo.Dao;

import com.questioncontrol.demo.Dto.Exampaper;
import com.questioncontrol.demo.Dto.QuestionData;
import org.springframework.data.repository.CrudRepository;

public interface ExampaperReponsitory extends CrudRepository<Exampaper,Integer> {

    boolean existsByExamname(String examname);

    Exampaper findByExamname(String examname);
}
