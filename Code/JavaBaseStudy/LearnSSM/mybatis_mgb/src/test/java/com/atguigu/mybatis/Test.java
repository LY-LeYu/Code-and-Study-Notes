package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.pojo.UserExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    @org.junit.Test
    public void Tset1() throws IOException {
        InputStream configStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(configStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession1.getMapper(UserMapper.class);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAgeBetween(0,22);
        List<User> list =  mapper.selectByExample(userExample);
        System.out.println(list);
    }
    @org.junit.Test
    public void testPage() throws IOException {
        InputStream configStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(configStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession1.getMapper(UserMapper.class);

        Page<Object> pages = PageHelper.startPage(1, 4);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailIsNull();
        List<User> list = mapper.selectByExample(userExample);
        list.forEach(System.out::println);
    }
}
