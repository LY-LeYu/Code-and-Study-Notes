package com.ly.study;

public class Account {
    private String name;
    private double deposit;

    public Account() {
    }

    public Account(String name, double deposit) {
        this.setName(name);
        this.setDeposit(deposit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            System.out.println("输入名字长度有误，必须在2~4个字符");
        }
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        if (deposit >= 0) {
            this.deposit = deposit;
        } else {
            System.out.println("请输入正确的余额，余额不可以为负数");
        }
    }

    public void accountInfo() {
        System.out.println("姓名："+this.name+"余额："+this.deposit);
    }
}
