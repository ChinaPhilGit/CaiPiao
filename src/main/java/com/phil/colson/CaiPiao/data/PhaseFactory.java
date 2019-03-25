package com.phil.colson.CaiPiao.data;

import com.phil.colson.CaiPiao.entity.CaiPiaoEntity;

import java.util.Calendar;
import java.util.Date;

public class PhaseFactory {


    public static CaiPiaoEntity generatePhase(Date dateTime) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);

        //生成期数时间

        int minuteOfDay = calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE);
        for (int i = minuteOfDay; true; i++) {
            if (i % 5 == 0) {
                minuteOfDay = i;
                break;
            }
        }
        CaiPiaoEntity entity = new CaiPiaoEntity();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.HOUR_OF_DAY, minuteOfDay / 60);

        calendar.set(Calendar.MINUTE, (minuteOfDay % 60) - 5);
        entity.setBeginTime(calendar.getTime());

        calendar.set(Calendar.MINUTE, (minuteOfDay % 60));
        entity.setEndTime(calendar.getTime());
        entity.setNumber1(RandomFactory.generateNumber());
        entity.setNumber2(RandomFactory.generateNumber());
        entity.setNumber3(RandomFactory.generateNumber());
        entity.setNumber4(RandomFactory.generateNumber());
        entity.setNumber5(RandomFactory.generateNumber());

        entity.setPhase(minuteOfDay/5);
        //计算一些属性
        entity.calculate();

        return entity;
    }

    public static void main(String[] args) {
        generatePhase(new Date());
    }
}
