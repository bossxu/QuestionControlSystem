package com.questioncontrol.demo.Controller;

import com.questioncontrol.demo.Dto.Level;
import com.questioncontrol.demo.Service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/level")
public class LevelControl {

    @Autowired
    QuestionServiceImpl questionService;

    @GetMapping("/all")
    public List<Level>GetallLevel()
    {
        return questionService.GetallLevel();
    }
}
