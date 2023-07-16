package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Test1 {
    @Test
    public void testInsert() throws IOException {
        //获取核心文件输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int result = mapper.insertUser();

        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();

    }
}
