package com.ly.extend_;

public class Students extends Person {
    String classbumber;

    public static void main(String[] args) {
        Students students = new Students();
        students.setName("xiaow");
        students.setGender('男');
        students.setAge(20);
        students.showInfo();
    }

}
