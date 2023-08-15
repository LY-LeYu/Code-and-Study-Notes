package com.ly.homework13;

public class Teacher extends Person{
    private int work_age;

    public Teacher(String name, String sex, int age, String hobby, int work_age) {
        super(name, sex, age, hobby);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public void teach() {
        System.out.println("教学");
    }

    @Override
    public String play() {
        return this.getName()+"的爱好是："+super.play();
    }
}
