package com.phil.colson.CaiPiao.controller;

import com.phil.colson.CaiPiao.data.PhaseFactory;
import com.phil.colson.CaiPiao.entity.CaiPiaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ScheduleTask {

    @Autowired
    private RedisTemplate<String, List<CaiPiaoEntity>> redisTemplate;

    @Scheduled(cron = "5 * * * * *")
    public void scheduleInsert2Data() {
        Date dateTime = new Date();
        List<CaiPiaoEntity> entityList = PhaseFactory.generatePhase(dateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        redisTemplate.opsForValue().set(sdf.format(dateTime), entityList);
    }

}
