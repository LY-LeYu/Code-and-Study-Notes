import java.util.Scanner;

public class StarsTower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入StarsTower的层数：");
        int n1 = scanner.nextInt(); //控制层数
        for (int i = 1; i <= n1; i++) {
            //打印空格
            for (int k = 1; k <= n1 - i; k++) {
                System.out.print(' ');
            }
            //打印*
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1 || i == n1) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            //控制换行
            System.out.print('\n');
        }

    }

}

