package recursion;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println("输入斐波那契数列中目标数字序号：");
            int num = scanner.nextInt();
            int res = recursion(num);
            System.out.println("结果为：" + res);
        }

    }

    private static int recursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2);
    }
}
