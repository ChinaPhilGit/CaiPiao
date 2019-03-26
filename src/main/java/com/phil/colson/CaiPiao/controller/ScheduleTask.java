package com.phil.colson.CaiPiao.controller;

import com.phil.colson.CaiPiao.data.PhaseFactory;
import com.phil.colson.CaiPiao.entity.CaiPiaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class ScheduleTask {

    @Autowired
    private RedisTemplate<String, CaiPiaoEntity> redisTemplate;

    @SuppressWarnings("Duplicates")
    @Scheduled(cron = "59 * * * * *")
    public void scheduleInsert2Data() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 5);
        CaiPiaoEntity caiPiaoEntity = PhaseFactory.generatePhase(calendar.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        DecimalFormat df = new DecimalFormat("000");

        String key = sdf.format(caiPiaoEntity.getBeginTime()) + df.format(caiPiaoEntity.getPhase());
        try {
            CaiPiaoEntity result = redisTemplate.opsForValue().get(key);
            if (result == null) {
                    result = PhaseFactory.generatePhase(calendar.getTime());
                    redisTemplate.opsForValue().set(key, result);
            }
        } catch (Exception ex) {
            redisTemplate.opsForValue().set(key, caiPiaoEntity);
        }

    }

}
