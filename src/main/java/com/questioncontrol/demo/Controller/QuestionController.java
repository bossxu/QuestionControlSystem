package com.questioncontrol.demo.Controller;


import com.questioncontrol.demo.Dao.QuestionDAtaReponsitory;
import com.questioncontrol.demo.Dto.QuestionData;
import com.questioncontrol.demo.Dto.QuestionInfo;
import com.questioncontrol.demo.Dto.Questiondto;
import com.questioncontrol.demo.Service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/question")
public class QuestionController {

    @Autowired
    QuestionServiceImpl questionService;

    @GetMapping(value = "/all")
    public List<QuestionInfo> GetAllquestions()
    {
        return questionService.GetAllQuestioninfo();
    }
// 传输格式
//    {
//        "qutype":"选择题",
//            "qudetail":"1+1=?",
//            "quans":"2",
//            "quval":1,
//            "qudifficult":1,
//            "schoolname":"上海大学",
//            "schooltype":"理工类",
//            "taglist":["math","算术"],
//        "levellist":["大一","大二"],
//        "examlist":["大一数学系月考","一年级数学系期末考"]
//    }
    @PostMapping(value = "/create")
    public String CreateNewQuestion(@RequestBody Questiondto questiondto)
    {
        questionService.createQuestion(questiondto);
        return "{\"state\":\"success\"}";
    }
    @PostMapping(value = "/{id}")
    public QuestionData GetOnequestiondetail(@PathVariable int id)
    {
        return questionService.GetQuestionDetail(id);
    }

    @PostMapping(value = "change")
    public String ChangeQuestion(@RequestBody Questiondto questiondto)
    {
        questionService.deleteQuestion(questiondto.getQuid());
        CreateNewQuestion(questiondto);
        return "{\"state\":\"success\"}";
    }
}
