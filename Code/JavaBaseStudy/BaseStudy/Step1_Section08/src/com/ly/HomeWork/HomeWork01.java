package com.ly.HomeWork;

public class HomeWork01 {
    public static void main(String[] args) {
        person[] personArr = {new person("张三", 70, "学生"), new person("李四", 30, "老师"),
                new person("王五", 50, "校长")};
        showArr(personArr);
        bubbleSort(personArr);
        System.out.println("排序后");
        showArr(personArr);

    }

    public static void bubbleSort(person[] Arr) {
        person temp;
        for (int i = 0; i < Arr.length - 1; i++) {
            for (int j = 0; j < Arr.length - i - 1; j++) {
                if (Arr[j].getAge() > Arr[j + 1].getAge()) {
                    temp = Arr[j];
                    Arr[j] = Arr[j + 1];
                    Arr[j + 1] = temp;
                }
            }
        }
    }

    public static void showArr(person[] Arr) {
        for (person i : Arr) {
            System.out.println(i.toString());
        }

    }

}

