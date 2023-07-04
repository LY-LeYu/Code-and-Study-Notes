package com.ly.homework13;

public class HomeWork13 {
    public static void main(String[] args) {
        Student student1 = new Student("小王", "男", 14, "踢足球", 12345);
        Student student2 = new Student("小李", "男", 12, "打游戏", 12346);
        Teacher teacher1 = new Teacher("老张", "男", 40, "钓鱼", 10);
        Teacher teacher2 = new Teacher("老郑", "男", 50, "下象棋", 20);
        Person[] person = {student1, student2, teacher1, teacher2};
        System.out.println("排序前");
        showArr(person);
        System.out.println("排序后");
        bubbleSort(person);
        showArr(person);
        test(person[1]);
        test(person[3]);
        System.out.println(student1.play());
        System.out.println(teacher1.play());

    }

    public static void test(Person person) {
        if (person instanceof Student) {
            ((Student) person).study();
        } else if (person instanceof Teacher) {
            ((Teacher) person).teach();
        }
    }


    public static void bubbleSort(Person[] Arr) {
        Person temp;
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

    public static void showArr(Person[] Arr) {
        for (Person i : Arr) {
            System.out.println(i.toString());
        }

    }

}
