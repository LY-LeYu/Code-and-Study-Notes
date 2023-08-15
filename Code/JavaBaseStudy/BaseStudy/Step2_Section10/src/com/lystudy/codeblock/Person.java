package com.lystudy.codeblock;

public class Person {
    public static int total;
    static{
        total = 100;
        System.out.println("静态代码块");

    }
}

class test {
    public static void main(String[] args) {
        System.out.println(Person.total);
        System.out.println(Person.total);

    }
}
