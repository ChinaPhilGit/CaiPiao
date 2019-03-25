package com.phil.colson.CaiPiao;

import com.phil.colson.CaiPiao.data.PhaseFactory;
import com.phil.colson.CaiPiao.entity.CaiPiaoEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaiPiaoApplicationTests {
    protected MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext
    @Autowired
    private RedisTemplate<String, CaiPiaoEntity> redisTemplate;

    @Before // 在测试开始前初始化工作
    public void setup() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void contextLoads() throws Exception {
//        Calendar calendar = Calendar.getInstance();
//        CaiPiaoEntity caiPiaoEntity = PhaseFactory.generatePhase(calendar.getTime());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        DecimalFormat df = new DecimalFormat("000");
//        String key = sdf.format(caiPiaoEntity.getBeginTime()) + df.format(caiPiaoEntity.getPhase());
//
//        redisTemplate.opsForValue().set(key, caiPiaoEntity);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

//        List<CaiPiaoEntity> result = redisTemplate.opsForValue().get(sdf.format(now));
//        CaiPiaoEntity caiPiaoEntity = result.stream().filter(n -> n.getBeginTime().before(now) && n.getEndTime().after(now)).findAny().get();

//        mockMvc.perform(MockMvcRequestBuilders.post("/caipiao/main/index")
////                .header("authorization", "Bearer " + token)
//                .param("dateTime", now.getTime() + "")
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//        ;
    }

}
