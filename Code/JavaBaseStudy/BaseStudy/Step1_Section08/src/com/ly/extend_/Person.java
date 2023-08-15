package com.ly.extend_;

public class Person {
    public String name;
    int age;
    char gender;

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void showInfo() {
        System.out.println("姓名："+name+"性别:"+gender+"年龄："+age);
    }
}
