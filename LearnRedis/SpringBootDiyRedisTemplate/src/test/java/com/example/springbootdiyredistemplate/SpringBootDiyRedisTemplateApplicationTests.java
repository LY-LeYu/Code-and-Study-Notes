package com.example.springbootdiyredistemplate;

import com.example.springbootdiyredistemplate.pojo.User;
import com.example.springbootdiyredistemplate.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringBootDiyRedisTemplateApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() throws JsonProcessingException {
        User user = new User("sj", 23);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    void testUtils() {
        User ly = new User("ly", 24);
        redisUtil.set("user1", ly.getName());
    }

}
