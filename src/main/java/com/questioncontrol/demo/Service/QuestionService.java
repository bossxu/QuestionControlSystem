package com.questioncontrol.demo.Service;


import com.questioncontrol.demo.Dto.*;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.List;

public interface QuestionService {

    void createQuestion(QuestionData question); //创建题目

    void deleteQuestion(int quid);  //删除题目

    QuestionTag GetQuestiontag(String tagname);  //通过tag名字来获得这个tag对象

    List<QuestionInfo> GetQuestionsbyTag(String tagname); // 通过tag名字来获得和这个tag搭边的所有题目id

    List<QuestionInfo> GetQuestionlistbykey(String key); // 通过这个key的value来获取相关所有搭边的题目id

    List<QuestionInfo> GetQuestionsbyExam(int examid);

    QuestionData GetQuestionDetail(int quid);   // 通过这个questionid 来获取具体的question信息

    List<QuestionTag> GetQuestiontags(int quid);  //通过这个questionid 来获得这个question所有的tag

    void addtag(QuestionTag tag);

    String gettagnamebyid(int tagid);

    void addLevel(Level level);

    void addExampaper(Exampaper exam);

    List<QuestionInfo> GetAllQuestioninfo();

    void createQuestion(Questiondto questiondto);

    List<QuestionTag> Getalltags();

    void deletetag(int id);

    List<Level> GetallLevel();

    List<Exampaper> GetallExam();

    List<Integer> GetrecommedQuestionlist(Recommed recommed);
}
