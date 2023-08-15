package com.ly.HomeWork;

public class HomeWork03 {
    public static void main(String[] args) {
        Professor jay = new Professor("jay", 30, 1000);
        associateProfessor jack = new associateProfessor("jack", 40, 1000);
        lecture white = new lecture("white", 50, 1000);
        System.out.println(jay.introduce());
        System.out.println(jack.introduce());
        System.out.println(white.introduce());
    }
}

class teacher {
    private String name;
    private int age;
    private String post;
    private double salary;

    public teacher(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String introduce() {
        return "姓名:" + name + "年龄:" + age + "职称:" + post + "基本工资:" + salary;
    }
}

class Professor extends teacher {
    private String post = "教授";
    public Professor(String name, int age, double salary) {
        super(name, age, salary);
    }



    @Override
    public String introduce() {
        return super.introduce() + "工资级别" + 1.3;
    }
}

class associateProfessor extends teacher {
    private String post = "副教授";

    public associateProfessor(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public String introduce() {
        return super.introduce() + "工资级别" + 1.2;
    }
}

class lecture extends teacher {
    private String post = "讲师";

    public lecture(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public String introduce() {
        return super.introduce() + "工资级别" + 1.1;
    }
}