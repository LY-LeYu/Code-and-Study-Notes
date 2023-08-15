package com.atguigu.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo1 {
    @Test
    public void test1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object helloSpring = ioc.getBean("HelloSpring");
    }

}
