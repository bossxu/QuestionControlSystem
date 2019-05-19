package com.questioncontrol.demo.Dto;

import java.util.ArrayList;
import java.util.List;

public class Questiondto {

    private String qutype; // 选择题，填空题，大题
    private String qudetail;
    private String quans;
    private double quval;
    private int qudifficult;
    private String schoolname;
    private String schooltype;
    private List<String> taglist;
    private List<String> levellist;
    private List<String> examlist;

    public Questiondto() {
        this.examlist = new ArrayList<>();
        this.levellist = new ArrayList<>();
        this.taglist = new ArrayList<>();
    }

    public String getQutype() {
        return qutype;
    }

    public void setQutype(String qutype) {
        this.qutype = qutype;
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

    public List<String> getTaglist() {
        return taglist;
    }

    public void setTaglist(List<String> taglist) {
        this.taglist = taglist;
    }

    public List<String> getLevellist() {
        return levellist;
    }

    public void setLevellist(List<String> levellist) {
        this.levellist = levellist;
    }

    public List<String> getExamlist() {
        return examlist;
    }

    public void setExamlist(List<String> examlist) {
        this.examlist = examlist;
    }
}
