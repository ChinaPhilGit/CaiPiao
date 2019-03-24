package com.phil.colson.CaiPiao.entity;

import com.phil.colson.CaiPiao.enums.EnumBigOrSmall;
import com.phil.colson.CaiPiao.enums.EnumDragonOrTiger;
import com.phil.colson.CaiPiao.enums.EnumSingleOrDouble;

import java.io.Serializable;
import java.util.Date;

public class CaiPiaoEntity implements Serializable {
    //期数
    private String phase;
    //时间
    private Date beginTime;
    private Date endTime;
    //第一个数
    private Integer number1;
    private Integer number2;
    private Integer number3;
    private Integer number4;
    //第五个数
    private Integer number5;

    private Integer sumNumber;

    //大小
    private EnumBigOrSmall bigOrSmall;
    //    单双
    private EnumSingleOrDouble singleOrDouble;
    //    龙虎
    private EnumDragonOrTiger dragonOrTiger;

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public EnumBigOrSmall getBigOrSmall() {
        return this.bigOrSmall;
    }

    private void setBigOrSmall() {
        if (sumNumber >= 23) {
            this.bigOrSmall = EnumBigOrSmall.大;
        } else {
            this.bigOrSmall = EnumBigOrSmall.小;
        }
    }

    public EnumSingleOrDouble getSingleOrDouble() {
        return singleOrDouble;
    }

    private void setSingleOrDouble() {
        if (sumNumber % 2 == 0)
            this.singleOrDouble = EnumSingleOrDouble.双;
        else
            this.singleOrDouble = EnumSingleOrDouble.单;
    }

    public EnumDragonOrTiger getDragonOrTiger() {
        return dragonOrTiger;
    }

    private void setDragonOrTiger() {
        if (number1 > number5) {
            this.dragonOrTiger = EnumDragonOrTiger.龙;
        } else if (number1 < number5) {
            this.dragonOrTiger = EnumDragonOrTiger.虎;
        } else {
            this.dragonOrTiger = EnumDragonOrTiger.合;
        }
    }

    private Integer getSumNumber() {
        return this.sumNumber;
    }

    private void setSumNumber() {
        this.sumNumber = this.number1 + this.number2 + this.number3 + this.number4 + this.number5;
    }
    public void calculate(){
        setSumNumber();
        setBigOrSmall();
        setDragonOrTiger();
        setSingleOrDouble();
    }
}
