package com.phil.colson.CaiPiao.data;

import com.phil.colson.CaiPiao.entity.CaiPiaoEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PhaseFactory {


    public static List<CaiPiaoEntity> generatePhase(Date dateTime) {
        List<CaiPiaoEntity> caiPiaoEntityList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);

        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        //生成期数时间
        Integer phase = 0;
        for (int i = 1; i <= 24 * 60; i++) {

            if (i % 5 == 0) {
                CaiPiaoEntity entity = new CaiPiaoEntity();
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.HOUR_OF_DAY, i / 60);

                calendar.set(Calendar.MINUTE, (i % 60) - 5);
                entity.setBeginTime(calendar.getTime());

                calendar.set(Calendar.MINUTE, (i % 60));
                entity.setEndTime(calendar.getTime());
                entity.setNumber1(RandomFactory.generateNumber());
                entity.setNumber2(RandomFactory.generateNumber());
                entity.setNumber3(RandomFactory.generateNumber());
                entity.setNumber4(RandomFactory.generateNumber());
                entity.setNumber5(RandomFactory.generateNumber());

                entity.setPhase((++phase).toString());
                //计算一些属性
                entity.calculate();
                caiPiaoEntityList.add(entity);
            }
        }

        return caiPiaoEntityList;
    }

    public static void main(String[] args) {
        generatePhase(new Date());
    }
}
