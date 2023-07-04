import java.util.Scanner;

public class RecursionExercises01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num = scanner.nextInt();
        recursionLearn test = new recursionLearn();
        int sum = test.fibnacci(num);
        if (sum>0) {
            System.out.print("第"+num+"位Fibnacci数="+sum);
        }

    }
}

class recursionLearn {
    public int fibnacci(int n) {
        if (n > 0) {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                return fibnacci(n - 1) + fibnacci(n - 2);
            }
        } else {
            System.out.println("仅支持大于0的整数！");
            return -1;
        }


    }

}