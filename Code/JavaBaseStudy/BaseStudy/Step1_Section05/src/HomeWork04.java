import java.util.Scanner;

public class HomeWork04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个三位整数：");
        int n = scanner.nextInt();
        int n1 = (int) Math.pow(n / 100, 3);
        int n2 = (int) Math.pow(n / 10 % 10, 3);
        int n3 = (int) Math.pow(n % 10, 3);
        if (n1 + n2 + n3 == n) {
            System.out.println("该数是水仙花数！");
        } else {
            System.out.println("该数不是水仙花数！");
        }


    }
}
