package com.atguigu.mybatis.test;

import com.atguigu.mybatis.Utils.SqlSessionUtil;
import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Test1 {
    @Test
    public void test1() throws IOException {
        InputStream configStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(configStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        System.out.println(sqlSession1);
        User user = mapper1.getUser(1);
        System.out.println(user);
//        sqlSession.clearCache();//清除sqlSession缓存
        CacheMapper mapper11 = sqlSession1.getMapper(CacheMapper.class);
        System.out.println(mapper11.getUser(1));

        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        System.out.println(sqlSession2);
        User user2 = mapper2.getUser(1);
        //同一个sqlSession,再次查询mybatis从一级缓存中查询
        System.out.println(user2);
        sqlSession2.close();
    }
}
