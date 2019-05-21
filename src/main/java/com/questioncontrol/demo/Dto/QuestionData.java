package com.questioncontrol.demo.Dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
@Entity
@Table(name = "questiondata")
public class QuestionData {

    @Id
    @GeneratedValue
    private Integer quid;

    private String qutype; // 选择题，填空题，大题
    private String qudetail;
    private String quans;
    private double quval;
    private int qudifficult;
    private String schoolname;
    private String schooltype;

    @JsonIgnoreProperties(value = "questionList")
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "tagconnect",
            joinColumns = {@JoinColumn(name = "quid")},
            inverseJoinColumns = {@JoinColumn(name = "tagid")}
    )
    private List<QuestionTag>taglist;

    @JsonIgnoreProperties(value = "questionDataList")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "levelconnect",
            joinColumns = {@JoinColumn(name = "quid")},
            inverseJoinColumns = {@JoinColumn(name = "levid")}
    )
    private List<Level> levelList;

    // 这个题目所被使用的试卷

    @JsonIgnoreProperties(value = "questionDataList")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "examconnect",
            joinColumns = {@JoinColumn(name = "quid")},
            inverseJoinColumns = {@JoinColumn(name = "examid")}
    )
    private List<Exampaper> examlist;



    public List<Level> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<Level> levelList) {
        this.levelList = levelList;
    }

    public List<Exampaper> getExamlist() {
        return examlist;
    }

    public void setExamlist(List<Exampaper> examlist) {
        examlist = examlist;
    }

    public void setQuid(Integer quid) {
        this.quid = quid;
    }

    public List<QuestionTag> getTaglist() {
        return taglist;
    }

    public void setTaglist(List<QuestionTag> taglist) {
        this.taglist = taglist;
    }


    public String getQudetail() {
        return qudetail;
    }

    public void setQudetail(String qudetail) {
        this.qudetail = qudetail;
    }

    public String getQuans() {
        return quans;
    }

    public void setQuans(String quans) {
        this.quans = quans;
    }

    public double getQuval() {
        return quval;
    }

    public void setQuval(double quval) {
        this.quval = quval;
    }

    public int getQudifficult() {
        return qudifficult;
    }

    public void setQudifficult(int qudifficult) {
        this.qudifficult = qudifficult;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String shoolname) {
        this.schoolname = shoolname;
    }

    public String getSchooltype() {
        return schooltype;
    }

    public void setSchooltype(String schooltype) {
        this.schooltype = schooltype;
    }

    public int getQuid() {
        return quid;
    }

    public void setQuid(int quid) {
        this.quid = quid;
    }

    public String getQutype() {
        return qutype;
    }

    public void setQutype(String qutype) {
        this.qutype = qutype;
    }
    public QuestionData(Questiondto questiondto)
    {
        this.quans = questiondto.getQuans();
        this.quid = 0;
        this.qudetail = questiondto.getQudetail();
        this.qutype = questiondto.getQutype();
        this.qudifficult = questiondto.getQudifficult();
        this.schoolname = questiondto.getSchoolname();
        this.schooltype = questiondto.getSchooltype();
        this.quval = questiondto.getQuval();
        this.taglist = new ArrayList<>();
        this.examlist = new ArrayList<>();
        this.levelList = new ArrayList<>();
    }
    public QuestionData()
    {
        this.levelList = new ArrayList<>();
        this.examlist = new ArrayList<>();
        this.taglist = new ArrayList<>();
    }
    public QuestionData(JSONObject questionjson)
    {
        try {
            this.quval = questionjson.getDouble("quval");
            this.schoolname = questionjson.getString("schoolname");
            this.qudifficult = questionjson.getInt("qudifficult");
            this.qutype = questionjson.getString("qutype");
            this.qudetail = questionjson.getString("qudetail");
            this.quid = 0;
            this.quans = questionjson.getString("quans");
            this.examlist = new ArrayList<>();
            this.levelList = new ArrayList<>();
            this.taglist = new ArrayList<>();
        }
        catch (Exception e)
        {
            System.out.println("题目创建失败");
        }
    }
    public void addtag(QuestionTag tag)
    {
        this.taglist.add(tag);
    }
    public void addlevel(Level level)
    {
        this.levelList.add(level);
    }
    public void addExam(Exampaper exam)
    {
        this.examlist.add(exam);
    }

}
