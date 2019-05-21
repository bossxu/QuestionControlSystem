package com.questioncontrol.demo.Dao;

import com.questioncontrol.demo.Dto.QuestionData;
import com.questioncontrol.demo.Dto.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionDAtaReponsitory extends CrudRepository<QuestionData,Integer> {

    @Query(value = "select * from questiondata q where "+
            "(q.qudetail like CONCAT('%',?1,'%')) or"+
            "(q.schoolname like CONCAT('%',?1,'%')) or"+
            "(q.quans like CONCAT('%',?1,'%'))",nativeQuery=true
    )
    List<QuestionData> findBykeyword(String keyword);
}
