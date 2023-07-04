package com.lystudy.codeblock;

public class Sample {
    public Sample() {
        System.out.println("默认构造器");
    }

    Sample(String s) {
        System.out.println(s);
    }
}

class Test {
    Sample sam1 = new Sample("sam1");
    static Sample sam2 = new Sample("static,sam2 initial");
    static{
        System.out.println("static block load");
        if (sam2 == null) {
            System.out.println("sam2 is null");
        }

    }
    public Test() {
        System.out.println("Test的构造器");
    }

    public static void main(String[] args) {
        Test a = new Test();
    }
}
