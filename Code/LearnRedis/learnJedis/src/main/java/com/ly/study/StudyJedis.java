package com.ly.study;

import redis.clients.jedis.Jedis;

import java.io.*;

public class StudyJedis {
    public static void main(String[] args) {
        //连接云服务器上的 Redis 服务
        Jedis jedis = new Jedis("localhost",6379);
//        jedis.auth("redis123"); //验证密码
        System.out.println("Connection to server successfully");
        //设置 redis 字符串数据
        Test test = new Test(10);
        System.out.println("对象为" + test.toString());
        System.out.println(test.value);

        // 将对象序列化为字节数组;
        byte[] serializedTest = serializeObject(test);
        byte[] bytes = {1, 1, 1, 1, 1};
        int[] arr = {1, 2, 3, 4, 5};
        // 将序列化后的字节数组存储在Redis中
        jedis.set("test:1".getBytes(), serializedTest);
        jedis.set("bytes".getBytes(), bytes);

        // 从Redis中检索对象并反序列化
        byte[] retrievedData = jedis.get("test:1".getBytes());
        Test retrievedPerson = deserializeObject(retrievedData);
        System.out.println("Retrieved test: " + retrievedPerson.toString());
        retrievedPerson.value = 20;
        System.out.println(retrievedPerson.value);

        System.out.println(test.value);

        // 关闭Redis连接
        jedis.close();
    }

    // 从字节数组序列化对象
    public static byte[] serializeObject(Object obj) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(obj);
            oos.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 从字节数组反序列化对象
    public static <T> T deserializeObject(byte[] data) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class Test implements Serializable {
    int value;

    public Test(int value) {
        this.value = value;
    }

}
