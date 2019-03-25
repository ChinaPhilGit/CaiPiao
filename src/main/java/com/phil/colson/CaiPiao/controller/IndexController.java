package com.phil.colson.CaiPiao.controller;

import com.phil.colson.CaiPiao.data.PhaseFactory;
import com.phil.colson.CaiPiao.entity.CaiPiaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RequestMapping("/caipiao/main")
@Controller
public class IndexController {

    @Autowired
    private RedisTemplate<String, CaiPiaoEntity> redisTemplate;

    @GetMapping("/index")
    public String index(Model model) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        DecimalFormat df = new DecimalFormat("000");
        int minuteOfDay = calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE);
        String key = sdf.format(calendar.getTime()) + df.format(minuteOfDay / 5);
        CaiPiaoEntity result = redisTemplate.opsForValue().get(key);
        if (result == null) {
            result = PhaseFactory.generatePhase(calendar.getTime());
            redisTemplate.opsForValue().set(key, result);
        }
        model.addAttribute("mo", result);
        model.addAttribute("nextPhase", (result.getPhase() + 1) + "");

        long different = result.getEndTime().getTime() - calendar.getTimeInMillis();
        model.addAttribute("nextPhase", (result.getPhase() + 1) + "");
        model.addAttribute("nextDifferent", different);
//            model.addAttribute("caiPiaoEntityList", caiPiaoEntityList);
        return "/index";
//        return ResponseEntity.ok(null);
    }

}
