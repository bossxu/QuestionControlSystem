package com.questioncontrol.demo.util;

import com.questioncontrol.demo.Dto.QuestionData;
import org.omg.CORBA.PUBLIC_MEMBER;

public class questionstruct {

    public int quid;
    public int quval;
    public int value;
    public questionstruct(QuestionData questionData,int difficult)
    {
        this.quid = questionData.getQuid();
        this.value = Math.abs(questionData.getQudifficult() - difficult);
        this.quval = (int)(questionData.getQuval()*2);
    }
}
