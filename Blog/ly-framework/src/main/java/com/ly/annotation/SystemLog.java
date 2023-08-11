package com.ly.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
@Retention(RetentionPolicy.RUNTIME)//标注注解使用在什么时候
@Target(ElementType.METHOD) //标注注解使用是在类上还是方法上
public @interface SystemLog {

    String businessName();
}
