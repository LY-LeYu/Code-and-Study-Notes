import java.util.Scanner;

public class HomeWork03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个年份：");
        int YEAR = scanner.nextInt();
        if ((YEAR % 4 == 0 && YEAR % 100 != 0) || YEAR % 400 == 0) {
            System.out.println("该年份是闰年！");
        } else {
            System.out.println("该年份不是闰年！");
        }
    }
}
