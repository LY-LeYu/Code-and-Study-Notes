package com.ly.changes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Changes {
    public static void main(String[] args) {
        double changes = 0;
        boolean flag = true;
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        String details = "------------收支明细--------------";
        do {
            System.out.println("-------------------零钱通---------------------");
            System.out.println("\t\t\t 1 零钱通明细");
            System.out.println("\t\t\t 2 存入");
            System.out.println("\t\t\t 3 消费");
            System.out.println("\t\t\t 4 退出");
            Scanner scanner = new Scanner(System.in);
            System.out.print("请选择你的操作：");
            int inPutNumber = scanner.nextInt();

            switch (inPutNumber) {
                case 1:
                    System.out.println(details);
                    break;
                case 2:
                    System.out.println("输入存入金额：");
                    double depositCash = scanner.nextDouble();
                    if (depositCash < 0) {
                        System.out.println("消费金额必须大于0");
                        break;
                    }
                    changes += depositCash;
                    date = new Date();
                    details += "\n消费:\t+" + depositCash + "\t" + "￥" + "\t" + "余额:" + changes + "\t"
                            + dateFormat.format(date);
                    break;
                case 3:
                    System.out.println("消费金额为：");
                    double consumerCash = scanner.nextDouble();
                    if (consumerCash < 0) {
                        System.out.println("消费金额必须大于0");
                        break;
                    }
                    if (changes - consumerCash < 0) {
                        System.out.println("余额不足！！！");
                        break;
                    }
                    changes -= consumerCash;
                    date = new Date();
                    details += "\n消费:\t-" + consumerCash + "\t" + "￥" + "\t" + "余额:" + changes + "\t"
                            + dateFormat.format(date);
                    break;
                case 4:
                    char chose;
                    while (true) {
                        System.out.println("你是否真的要退出？（Y\\N）");
                        chose = scanner.next().charAt(0);
                        if (chose == 'Y' || chose == 'y' || chose == 'N' || chose == 'n') {
                            break;
                        }
                    }
                    if (chose == 'Y' || chose == 'y') {
                        flag = false;
                    }

            }
        } while (flag);

    }


}
