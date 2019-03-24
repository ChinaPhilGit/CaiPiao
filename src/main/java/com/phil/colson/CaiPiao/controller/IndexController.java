package com.phil.colson.CaiPiao.controller;

import com.phil.colson.CaiPiao.entity.CaiPiaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/caipiao/main")
@Controller
public class IndexController {

    @Autowired
    private RedisTemplate<String, List<CaiPiaoEntity>> redisTemplate;

    @PostMapping("/index")
    public ResponseEntity index(Long dateTime) {
        Assert.notNull(dateTime, "dateTime不能为空");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        List<CaiPiaoEntity> result = redisTemplate.opsForValue().get(sdf.format(new Date(dateTime)));
        if (result.stream().allMatch(n -> n.getBeginTime().before(new Date(dateTime)) && n.getEndTime().after(new Date(dateTime)))) {

            CaiPiaoEntity caiPiaoEntity = result.stream().filter(n -> n.getBeginTime().before(new Date(dateTime)) && n.getEndTime().after(new Date(dateTime))).findAny().get();
            return ResponseEntity.ok(caiPiaoEntity);
        }
        return ResponseEntity.ok(null);
    }

}
