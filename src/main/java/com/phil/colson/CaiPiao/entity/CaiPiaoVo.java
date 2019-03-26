package com.phil.colson.CaiPiao.entity;

import java.io.Serializable;

public class CaiPiaoVo implements Serializable {

    private static final long serialVersionUID = 4163352421351364822L;
    //期数
    private String phase;
    //第一个数
    private Integer number1;
    private Integer number2;
    private Integer number3;
    private Integer number4;
    //第五个数
    private Integer number5;

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }


    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public Integer getNumber3() {
        return number3;
    }

    public void setNumber3(Integer number3) {
        this.number3 = number3;
    }

    public Integer getNumber4() {
        return number4;
    }

    public void setNumber4(Integer number4) {
        this.number4 = number4;
    }

    public Integer getNumber5() {
        return number5;
    }

    public void setNumber5(Integer number5) {
        this.number5 = number5;
    }
}
