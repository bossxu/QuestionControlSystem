package com.questioncontrol.demo.Dto;

public class Recommed {

    private String qutype;
    private int value;
    private int difficult;
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getQutype() {
        return qutype;
    }

    public void setQutype(String qutype) {
        this.qutype = qutype;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }
}
