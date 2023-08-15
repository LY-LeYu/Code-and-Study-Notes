package com.ly.homework13;

public class Student extends Person{

    private long stu_id;

    public Student(String name, String sex, int age, String hobby, long stu_id) {
        super(name, sex, age, hobby);
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("学习");
    }

    @Override
    public String play() {
        return this.getName()+"的爱好是："+super.play();
    }
}
