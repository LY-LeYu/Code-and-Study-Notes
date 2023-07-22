package com.atguigu.spring;

import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo1 {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //id获取bean
        Object student = ioc.getBean("Student");
        //spring获取java bean的三种方式
        //class类获取bean
//        Student beanStudent = ioc.getBean(Student.class);
        System.out.println(student);
        //id+class类型获取
//        Student student1 = ioc.getBean("Student1", Student.class);
//        System.out.println(student1);
//        //默认是单例模式
//        System.out.println(student == student1);

    }


}
