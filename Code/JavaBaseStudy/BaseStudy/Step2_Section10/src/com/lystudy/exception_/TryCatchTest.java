package com.lystudy.exception_;

import java.util.Scanner;

public class TryCatchTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        while(true) {
            try {
                String input = sc.next();
                num = Integer.parseInt(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("您的输入有误！请重新输入：");
            }
        }
        System.out.println(num);

    }
}
