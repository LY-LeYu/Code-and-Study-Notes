package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {
    @Test
    public void testInsertUser() throws IOException {
        //获取核心文件输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int result = mapper.insertUser();

//        int result = sqlSession.insert("com.atguigu.mybatis.mapper.UserMapper.insertUser");

        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapperUpdate = sqlSession.getMapper(UserMapper.class);
        int result = mapperUpdate.updateUser();
    }

    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapperDelete = sqlSession.getMapper(UserMapper.class);
        int result = mapperDelete.deleteUser();
    }

    @Test
    public void testSelectUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapperSelect = sqlSession.getMapper(UserMapper.class);
        User x1 = mapperSelect.selectUser();
        System.out.println(x1);
    }

    @Test
    public void testSelectAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapperSelectAll = sqlSession.getMapper(UserMapper.class);
        List x1 = mapperSelectAll.selectAllUser();
        for (Object o : x1) {
            System.out.println(o);
        }
    }
}
