package com.questioncontrol.demo.Dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuestionInfo {
    // 这个是返回给前端的简易版信息对象。

    private int quid;
    private double quval;
    private int qudifficult;
    private String schoolname;
    private String schooltype;
    private List<String> taglist;

    public QuestionInfo(){
        taglist = new ArrayList<>();
    }
    public QuestionInfo(QuestionData questiondetail)
    {
        this.quid = questiondetail.getQuid();
        this.quval = questiondetail.getQuval();
        this.qudifficult = questiondetail.getQudifficult();
        this.schoolname = questiondetail.getSchoolname();
        this.schooltype = questiondetail.getSchooltype();
        this.taglist = new ArrayList<>();
        for(int i = 0;i<questiondetail.getTaglist().size();i++)
        {
            this.taglist.add(questiondetail.getTaglist().get(i).getTagname());
        }
    }

    public int getQuid() {
        return quid;
    }

    public void setQuid(int quid) {
        this.quid = quid;
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

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
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
}
