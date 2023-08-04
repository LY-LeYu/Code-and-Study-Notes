package com.example.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class controller {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test")
    public String testRedis(){
        return stringRedisTemplate.opsForValue().get("name1");
    }
}
