package com.lystudy.enum_;

public class Demo1 {
    public static void main(String[] args) {

        System.out.println(demo11.SUMMER);
        System.out.println(demo11.WINTER);

    }
}

class demo11 {
    private String name;
    private String desc;
    public static final demo11 SUMMER = new demo11("summer","hot");
    public static  final demo11 WINTER = new demo11("winter","cool");

    private demo11(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "demo11{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}