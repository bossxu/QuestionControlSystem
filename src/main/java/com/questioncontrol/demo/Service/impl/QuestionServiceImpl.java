package com.questioncontrol.demo.Service.impl;


import com.questioncontrol.demo.Dao.ExampaperReponsitory;
import com.questioncontrol.demo.Dao.LevelReponsitory;
import com.questioncontrol.demo.Dao.QuestionDAtaReponsitory;
import com.questioncontrol.demo.Dao.QuestionTagReponsitory;
import com.questioncontrol.demo.Dto.*;
import com.questioncontrol.demo.Service.QuestionService;
import com.questioncontrol.demo.util.Recommedalgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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
    public List<QuestionInfo> GetQuestionsbyTag(String tagname) {
        List<QuestionInfo> questionidlist = new ArrayList<>();
        List<QuestionData> questionDataList = GetQuestiontag(tagname).getQuestionList();
        Iterator<QuestionData> it= questionDataList.listIterator();
        while(it.hasNext())
        {
            questionidlist.add(new QuestionInfo(it.next()));
        }
        return questionidlist;
    }

    @Override
    public List<QuestionInfo> GetQuestionlistbykey(String key) {
        List<QuestionInfo> questionInfoList  = new ArrayList<>();
        List<QuestionData> questionDataList = questionDataReponsitory.findBykeyword(key);
        Iterator<QuestionData> it = questionDataList.listIterator();
        while(it.hasNext())
        {
            questionInfoList.add(new QuestionInfo(it.next()));
        }
        return questionInfoList;
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

    @Override
    public List<QuestionTag> Getalltags() {
        Iterator<QuestionTag> it = questionTagReponsitory.findAll().iterator();
        List<QuestionTag> questionTagList = new ArrayList<>();
        while(it.hasNext())
        {
            questionTagList.add(it.next());
        }
        return questionTagList;
    }

    @Override
    public void deletetag(int id) {
        questionTagReponsitory.deleteById(id);
    }

    @Override
    public List<Level> GetallLevel() {
        Iterator<Level> it = levelReponsitory.findAll().iterator();
        List<Level> levelList = new ArrayList<>();
        while(it.hasNext())
        {
            levelList.add(it.next());
        }
        return levelList;
    }

    @Override
    public List<Exampaper> GetallExam() {
        Iterator<Exampaper> it = exampaperReponsitory.findAll().iterator();
        List<Exampaper> examList = new ArrayList<>();
        while(it.hasNext())
        {
            examList.add(it.next());
        }
        return examList;
    }

    @Override
    public List<QuestionInfo> GetQuestionsbyExam(int examid) {
        Exampaper exampaper= exampaperReponsitory.findById(examid).get();
        List<QuestionInfo> questionInfoList = new ArrayList<>();
        Iterator<QuestionData> it = exampaper.getQuestionDataList().listIterator();
        while(it.hasNext())
        {
            questionInfoList.add(new QuestionInfo(it.next()));
        }
        return questionInfoList;
    }

    @Override
    public String gettagnamebyid(int tagid) {
        return questionTagReponsitory.findById(tagid).get().getTagname();
    }

    @Override
    public List<Integer> GetrecommedQuestionlist(Recommed recommed) {
        Recommedalgorithm algorithm = new Recommedalgorithm(recommed , questionDataReponsitory.findbyqutype(recommed.getQutype()));
        return algorithm.Getquestionslist();
    }
}
