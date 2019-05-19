package com.questioncontrol.demo.Service.impl;


import com.questioncontrol.demo.Dao.ExampaperReponsitory;
import com.questioncontrol.demo.Dao.LevelReponsitory;
import com.questioncontrol.demo.Dao.QuestionDAtaReponsitory;
import com.questioncontrol.demo.Dao.QuestionTagReponsitory;
import com.questioncontrol.demo.Dto.*;
import com.questioncontrol.demo.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDAtaReponsitory questionDataReponsitory;

    @Autowired
    QuestionTagReponsitory questionTagReponsitory;

    @Autowired
    LevelReponsitory levelReponsitory;

    @Autowired
    ExampaperReponsitory exampaperReponsitory;



    @Override
    public void createQuestion(QuestionData question) {
        questionDataReponsitory.save(question);
    }

    @Override
    public void deleteQuestion(int quid) {
        questionDataReponsitory.deleteById(quid);
    }

    @Override
    public QuestionTag GetQuestiontag(String tagname) {

       return questionTagReponsitory.findByTagname(tagname);

    }

    @Override
    public List<Integer> GetQuestionsbyTag(String tagname) {
        List<Integer> questionidlist = new ArrayList<>();
        List<QuestionData> questionDataList = GetQuestiontag(tagname).getQuestionList();
        Iterator<QuestionData> it= questionDataList.listIterator();
        while(it.hasNext())
        {
            questionidlist.add(it.next().getQuid());
        }
        return questionidlist;
    }

    @Override
    public List<Integer> GetQuestionlistbykey(String key) {
        return null;
    }

    @Override
    public QuestionData GetQuestionDetail(int quid) {
        return questionDataReponsitory.findById(quid).get();
    }

    @Override
    public List<QuestionTag> GetQuestiontags(int quid) {
        return  GetQuestionDetail(quid).getTaglist();
    }

    @Override
    public void addtag(QuestionTag tag) {
        if(!questionTagReponsitory.existsByTagname(tag.getTagname())) {
            questionTagReponsitory.save(tag);
        }
    }

    @Override
    public void addLevel(Level level) {
        if(!levelReponsitory.existsByLevelName(level.getLevelName()))
        {
            levelReponsitory.save(level);
        }
    }

    @Override
    public void addExampaper(Exampaper exam) {
        if(!exampaperReponsitory.existsByExamname(exam.getExamname()))
        {
            exampaperReponsitory.save(exam);
        }
    }

    @Override
    public List<QuestionInfo> GetAllQuestioninfo() {
        Iterator<QuestionData> it = questionDataReponsitory.findAll().iterator();
        List<QuestionInfo> questionInfoList = new ArrayList<>();
        while(it.hasNext())
        {
            questionInfoList.add(new QuestionInfo(it.next()));
        }
        return questionInfoList;
    }

    @Override
    public void createQuestion(Questiondto questiondto) {
        Iterator<String> it = questiondto.getExamlist().listIterator();
        QuestionData questionData = new QuestionData(questiondto);
        while(it.hasNext())
        {
            String examname = it.next();
            if(!exampaperReponsitory.existsByExamname(examname))
            {
                exampaperReponsitory.save(new Exampaper(examname));
            }
            questionData.addExam(exampaperReponsitory.findByExamname(examname));
        }
        it = questiondto.getLevellist().listIterator();
        while(it.hasNext())
        {
            String levelname = it.next();
            if(!levelReponsitory.existsByLevelName(levelname))
            {
                levelReponsitory.save(new Level(levelname));
            }
            questionData.addlevel(levelReponsitory.findByLevelName(levelname));
        }
        it = questiondto.getTaglist().listIterator();
        while (it.hasNext())
        {
            String tagname = it.next();
            if(!questionTagReponsitory.existsByTagname(tagname))
            {
                questionTagReponsitory.save(new QuestionTag(tagname));
            }
            questionData.addtag(questionTagReponsitory.findByTagname(tagname));
        }
        questionDataReponsitory.save(questionData);
    }
}
