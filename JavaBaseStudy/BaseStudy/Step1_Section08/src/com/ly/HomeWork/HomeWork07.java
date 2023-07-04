package com.ly.HomeWork;

public class HomeWork07 extends test {
    String name = "jack";

    public HomeWork07() {
        System.out.println("HomeWork07");
    }

    public HomeWork07(String name) {
        super(name);
    }

    public void test() {
        System.out.println(super.name);
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        new HomeWork07().test();
        new HomeWork07("John").test();
    }

}


class test {
    String name = "rose";

    public test() {
        System.out.println("test");
    }

    public test(String name) {
        this.name = name;
    }
}
