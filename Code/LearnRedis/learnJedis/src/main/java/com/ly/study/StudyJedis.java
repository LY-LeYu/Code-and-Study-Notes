package com.ly.study;

import redis.clients.jedis.Jedis;

public class StudyJedis {
    public static void main(String[] args) {
        //连接云服务器上的 Redis 服务
        Jedis jedis = new Jedis("1.14.97.92",6379);
        jedis.auth("redis123"); //验证密码
        System.out.println("Connection to server successfully");
        //设置 redis 字符串数据
        jedis.set("w3ckey", "Redis tutorial");
        // 获取存储的数据并输出
        System.out.println("Stored string in redis:: "+ jedis.get("w3ckey"));
    }
}
