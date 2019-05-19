package com.questioncontrol.demo.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "level")
public class Level {
    // 这个表示得意思是每一种题型所对应的可以使用的年级

    @Id
    @GeneratedValue
    Integer levid = 0;

    @Column(name = "Levelname")
    String levelName;

    @JsonIgnore
    @ManyToMany(mappedBy = "levelList",fetch = FetchType.LAZY)
    List<QuestionData> questionDataList;

    public List<QuestionData> getQuestionDataList() {
        return questionDataList;
    }

    public void setQuestionDataList(List<QuestionData> questionDataList) {
        this.questionDataList = questionDataList;
    }

    public Integer getLevid() {
        return levid;
    }

    public void setLevid(Integer levid) {
        levid = levid;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        levelName = levelName;
    }

    public Level() {
        this.levid = 0;
        this.questionDataList = new ArrayList<>();
    }
    public Level(String levelname)
    {
        this.levid = 0;
        this.questionDataList = new ArrayList<>();
        this.levelName = levelname;
    }
}
