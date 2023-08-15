package com.lystudy.exception_;

import java.util.Scanner;

public class EcmDef {
    int num1, num2;


    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public int cal(int num1,int num2) {
        return num1 / num2;
    }
}
