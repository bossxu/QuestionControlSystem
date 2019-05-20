package com.questioncontrol.demo.Controller;


import com.questioncontrol.demo.Dto.QuestionInfo;
import com.questioncontrol.demo.Dto.QuestionTag;
import com.questioncontrol.demo.Dto.Tagdto;
import com.questioncontrol.demo.Service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/tag")
public class TagController  {

    @Autowired
    QuestionServiceImpl questionService;

    @GetMapping(value = "/all")
    public List<QuestionTag> Getalltags()
    {
        return questionService.Getalltags();
    }

    @PostMapping(value = "/create")
    public String AddTag(@RequestBody Tagdto tagdto)
    {
        tagdto.setTagid(0);
        questionService.addtag(new QuestionTag(tagdto));
        return "{\"state\":\"success\"}";
    }
    @DeleteMapping(value = "/delete/{id}")
    public String DeleteTag(@PathVariable int id)
    {
        try {
            questionService.deletetag(id);
        }
        catch (Exception e)
        {
            return "{\"state\":\"error\"}";
        }
        return "{\"state\":\"success\"}";
    }

    @GetMapping(value = "/questions/{id}")
    public List<QuestionInfo> GetQuestionsbyid(@PathVariable String id) throws Exception
    {
        String tagname = questionService.gettagnamebyid(new Integer(id));
        System.out.println(tagname);
        return questionService.GetQuestionsbyTag(tagname);
    }
}
