import java.util.Scanner;

public class MethodExercises01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = scanner.nextInt();
        math math = new math();
        boolean index = math.isOdd(num);
        if (index) {
            System.out.println("该数为偶数");

        } else {

            System.out.println("该数为奇数");
        }
        math.plot(num,num,'*');

    }
}

class math {
    public boolean isOdd(int num) {
        boolean index = false;
        if (num % 2 == 0) {
            index = true;
        }
        return index;
    }

    public void plot(int row, int col, char symbols) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(symbols+"\t");
            }
            System.out.print("\n");

        }
    }

}
