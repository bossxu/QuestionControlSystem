package com.questioncontrol.demo.Dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questiontag")
public class QuestionTag {

    @Id
    @GeneratedValue
    private Integer tagid;

    @Column(name = "tagname")
    private String tagname;

    public int getTagid() {
        return tagid;
    }

    @ManyToMany(mappedBy = "taglist",fetch=FetchType.EAGER)
    @JsonIgnore
    private List<QuestionData> QuestionList;

    public QuestionTag(String tagname) {
        this.tagname = tagname;
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
        this.QuestionList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "{" +
                "tagname='" + tagname + '\'' +
                "}";
    }
}
