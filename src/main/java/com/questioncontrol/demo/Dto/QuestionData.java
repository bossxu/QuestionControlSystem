package com.questioncontrol.demo.Dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questiondata")
public class QuestionData {

    @Id
    @GeneratedValue
    private Integer quid;

    private String qutype;
    private String qudetail;
    private String quans;
    private double quval;
    private int qudifficult;
    private String shoolname;
    private String schooltype;
    private String level;

    @JsonIgnore
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "tagconnect",
            joinColumns = {@JoinColumn(name = "quid")},
            inverseJoinColumns = {@JoinColumn(name = "tagid")}
    )
    private List<QuestionTag>taglist;

    public void setQuid(Integer quid) {
        this.quid = quid;
    }

    public List<QuestionTag> getTaglist() {
        return taglist;
    }

    public void setTaglist(List<QuestionTag> taglist) {
        this.taglist = taglist;
    }

    public QuestionData(String qutype) {
        this.qutype = qutype;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getShoolname() {
        return shoolname;
    }

    public void setShoolname(String shoolname) {
        this.shoolname = shoolname;
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
    public QuestionData()
    {
        this.taglist = new ArrayList<>();
    }
}
