import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int n = scanner.nextInt();
        if (n > 0) {
            System.out.println("大于0");
        } else if (n < 0) {
            System.out.println("小于0");
        } else {
            System.out.println("等于0");
        }
    }
}
