package com.questioncontrol.demo.util;

import com.questioncontrol.demo.Dao.QuestionDAtaReponsitory;
import com.questioncontrol.demo.Dto.QuestionData;
import com.questioncontrol.demo.Dto.QuestionInfo;
import com.questioncontrol.demo.Dto.Recommed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

public class Recommedalgorithm {

    Recommed recommed;
    List<questionstruct> questionlist = new ArrayList<>();
    que [][]dp = new que[30][200];

    @Autowired
    QuestionDAtaReponsitory questionDAtaReponsitory;

    public Recommedalgorithm(Recommed recommed, List<QuestionData> questions)
    {
        this.recommed = recommed;
        this.recommed.setValue(this.recommed.getValue()*2);
        for(int i = 0;i<30;i++)
        {
            for(int j = 0;j<30;j++)
            {
                dp[i][j] = new que();
            }
        }
        for (int i = 0;i<questions.size();i++)
        {
            this.questionlist.add(new questionstruct(questions.get(i),recommed.getDifficult()));
        }
    }

    public void Get(int index, int num, int quval,int value,int pre)
    {
        if(dp[num][quval].value > value)
        {
            dp[num][quval].value = value;
            dp[num][quval].pre = pre;
        }
        if(index >= questionlist.size() || num > recommed.getNum() || quval>recommed.getValue())
            return ;
        questionstruct a = questionlist.get(index);
        Get(index+1,num+1,quval+a.quval,value+a.value,index);
        Get(index+1,num,quval,value,pre);
    }

    public List<Integer>Getquestionslist()
    {
        List<Integer> questions = new ArrayList<>();
        Get(0,0,0,0,-1);
        if(dp[recommed.getNum()][recommed.getValue()].pre == -1)
        {
            return questions;
        }
        int num = recommed.getNum();
        int value = recommed.getValue();
        while(dp[num][value].pre != -1)
        {
            questions.add(dp[num][value].pre);
            value -= this.questionlist.get(dp[num][value].pre).quval;
            num -= 1;
        }
        return questions;
    }

}
