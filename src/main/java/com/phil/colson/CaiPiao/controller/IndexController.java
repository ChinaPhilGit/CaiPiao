package com.phil.colson.CaiPiao.controller;

import com.phil.colson.CaiPiao.data.PhaseFactory;
import com.phil.colson.CaiPiao.entity.CaiPiaoEntity;
import com.phil.colson.CaiPiao.entity.CaiPiaoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequestMapping("/caipiao/main")
@Controller
public class IndexController {

    @Autowired
    private RedisTemplate<String, CaiPiaoEntity> redisTemplate;


    @GetMapping("/index")
    public String index(Model model) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
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

        List<CaiPiaoEntity> caiPiaoEntityList = new ArrayList<>();

        for (int i = result.getPhase() - 1, j = 0; true; i--, j++) {
            if (i <= 0) {
                calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
                i = 288;
            }
            if (j >= 288) {
                break;
            }
            key = sdf.format(calendar.getTime()) + df.format(i);
            CaiPiaoEntity entity = redisTemplate.opsForValue().get(key);
            if (entity != null) {
                caiPiaoEntityList.add(entity);
            }
        }
        model.addAttribute("caiPiaoEntityList", caiPiaoEntityList);
        return "/index";
    }

    @GetMapping("/edit")
    public String edit() {
        return "/edit";
    }

    @PostMapping("/do/edit")
    @ResponseBody
    public String doEdit(@ModelAttribute CaiPiaoVo vo) {
        CaiPiaoEntity caiPiaoEntity = redisTemplate.opsForValue().get(vo.getPhase());
        if (vo.getNumber1() != null)
            caiPiaoEntity.setNumber1(vo.getNumber1());
        if (vo.getNumber2() != null)
            caiPiaoEntity.setNumber2(vo.getNumber2());
        if (vo.getNumber3() != null)
            caiPiaoEntity.setNumber3(vo.getNumber3());
        if (vo.getNumber4() != null)
            caiPiaoEntity.setNumber4(vo.getNumber4());
        if (vo.getNumber5() != null)
            caiPiaoEntity.setNumber5(vo.getNumber5());
        redisTemplate.opsForValue().set(vo.getPhase(), caiPiaoEntity);
        return "修改成功";
    }

    @PostMapping("/query/edit")
    @ResponseBody
    public CaiPiaoEntity queryEdit(String phase) {

        return redisTemplate.opsForValue().get(phase);
    }

}
