package com.ly.changes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChanges_OOP {
    private double changes;
    private String details = "------------收支明细--------------";
    private Date date;
    private boolean flag = true;
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat();

    public void showMenu() {
        do {
            System.out.println("-------------------零钱通---------------------");
            System.out.println("\t\t\t 1 零钱通明细");
            System.out.println("\t\t\t 2 存入");
            System.out.println("\t\t\t 3 消费");
            System.out.println("\t\t\t 4 退出");
            System.out.print("请选择你的操作：");
            int inPutNumber = scanner.nextInt();
            switch (inPutNumber) {
                case 1:
                    details();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    consume();
                    break;
                case 4:
                    quit();
                    break;
                default:
                    System.out.println("输入命令有误！");
            }
        } while (flag);
    }

    public void details() {
        System.out.println(details);
    }

    public void deposit() {
        System.out.println("输入存入金额：");
        double depositCash = scanner.nextDouble();
        if (depositCash < 0) {
            System.out.println("存入金额必须大于0");
            return;
        }
        changes += depositCash;
        date = new Date();
        details += "\n存入:\t+" + depositCash + "\t" + "￥" + "\t" + "余额:" + changes + "\t"
                + dateFormat.format(date);
    }

    public void consume() {
        System.out.println("消费金额为：");
        double consumerCash = scanner.nextDouble();
        if (consumerCash < 0) {
            System.out.println("消费金额必须大于0");
            return;
        }
        if (changes - consumerCash < 0) {
            System.out.println("余额不足！！！");
            return;
        }
        changes -= consumerCash;
        date = new Date();
        details += "\n消费:\t-" + consumerCash + "\t" + "￥" + "\t" + "余额:" + changes + "\t"
                + dateFormat.format(date);
    }

    public void quit() {
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


}
