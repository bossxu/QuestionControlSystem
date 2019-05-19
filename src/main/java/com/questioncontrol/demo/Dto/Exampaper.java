package com.questioncontrol.demo.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
@Entity
@Table(name = "Exampaper")
public class Exampaper {

    @Id
    @GeneratedValue
    private Integer examid = 0;

    private String examname;

    private String examdate;

    @JsonIgnore
    @ManyToMany(mappedBy = "examlist", fetch = FetchType.LAZY)
    private List<QuestionData> questionDataList;

    public Exampaper(String examname) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.examdate = df.format(new Date());
        this.examid = 0;
        this.examname = examname;
    }
    public Exampaper()
    {
        this.examid = 0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.examdate = df.format(new Date());
    }

    public List<QuestionData> getQuestionDataList() {
        return questionDataList;
    }

    public void setQuestionDataList(List<QuestionData> questionDataList) {
        this.questionDataList = questionDataList;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        examid = examid;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        examname = examname;
    }

    public String getExamdate() {
        return examdate;
    }

    public void setExamdate(String examdate) {
        examdate = examdate;
    }
}
