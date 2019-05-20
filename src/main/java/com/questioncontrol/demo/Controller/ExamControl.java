package com.questioncontrol.demo.Controller;

import com.questioncontrol.demo.Dto.Exampaper;
import com.questioncontrol.demo.Dto.QuestionInfo;
import com.questioncontrol.demo.Service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/exam")
public class ExamControl {
    @Autowired
    QuestionServiceImpl questionService;

    @GetMapping(value = "/all")
    public List<Exampaper> Getallexam()
    {
        return questionService.GetallExam();
    }

    @GetMapping(value = "/questions/{id}")
    public List<QuestionInfo> GetQuestionsbyexamid(@PathVariable int id)
    {
        return  questionService.GetQuestionsbyExam(id);
    }
}
