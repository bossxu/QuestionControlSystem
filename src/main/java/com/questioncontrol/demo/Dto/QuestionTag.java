package com.questioncontrol.demo.Dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questiontag")
public class QuestionTag {

    // 小一点的tag 函数,数列

    @Id
    @GeneratedValue
    private Integer tagid = 0;

    @Column(name = "tagname")
    private String tagname;

    public int getTagid() {
        return tagid;
    }

    @ManyToMany(mappedBy = "taglist",fetch=FetchType.EAGER)
    @JsonIgnore
    private List<QuestionData> questionList;

    public QuestionTag(String tagname) {
        this.tagid = 0;
        this.tagname = tagname;
        this.questionList = new ArrayList<>();
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public QuestionTag()
    {
        this.tagid = 0;
        this.tagname = "init";
        this.questionList = new ArrayList<>();
    }

    public List<QuestionData> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionData> questionList) {
        questionList = questionList;
    }



    @Override
    public String toString() {
        return "{" +
                "tagname='" + tagname + '\'' +
                "}";
    }

    public QuestionTag(Tagdto tagdto)
    {
        this.tagid = tagdto.getTagid();
        this.tagname = tagdto.getTagname();
        this.questionList = new ArrayList<>();
    }
}
