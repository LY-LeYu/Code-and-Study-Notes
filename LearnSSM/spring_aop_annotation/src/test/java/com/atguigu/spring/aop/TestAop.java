package com.atguigu.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_aoc_annotation.xml");
        Calculator calculator = applicationContext.getBean(Calculator.class);
//        int result = calculator.add(1, 1);
        int result = calculator.div(1, 1);
    }
}
