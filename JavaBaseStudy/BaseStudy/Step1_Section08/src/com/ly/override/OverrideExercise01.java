package com.ly.override;

public class OverrideExercise01 {
    public static void main(String[] args) {
        Students students = new Students("jack",20, 12345, 01);
        System.out.println(students.say());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String say() {
        return "Name is:"+name+"\t"+";Age is:"+age;
    }
}

class Students extends Person {
    private int id;
    public  int score;

    public Students(String name, int age, int id, int score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public String say() {
        return super.say()+"\t"+";ID is:" +id+"\t"+";Score is:"+score;
    }
}
