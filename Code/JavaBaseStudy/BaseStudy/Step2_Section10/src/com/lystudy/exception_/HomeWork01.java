package com.lystudy.exception_;

import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EcmDef ecmDef = new EcmDef();
        try {
              String[] args1 = new String[2];
            args1[0] = scanner.next();
            args1[1] = scanner.next();
            int num1 = Integer.parseInt(args1[0]);
            int num2 = Integer.parseInt(args1[1]);
            ecmDef.setNum1(num1);
            ecmDef.setNum2(num2);
            int ans = ecmDef.cal(num1,num2);
            System.out.println(ans);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("输入参数不正确");
        } catch (ArithmeticException e) {
            System.out.println("除数不能为零");
        }

    }


}
