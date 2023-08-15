package com.lystudy.enum_;

public class EnumExercise02 {
    public static void main(String[] args) {
        Week[] weekValues = Week.values();
        for (Week week : weekValues) {
            System.out.println(week.toString());
        }
    }


}

enum Week {
    MONDAY("星期一"),TUESDAY("星期二"), WEDNESDAY("星期三"),
    THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六"),
    SUNDAY("星期日");
    String name;

    Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Week{" +
                "name='" + name + '\'' +
                '}';
    }
}