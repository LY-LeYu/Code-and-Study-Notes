import java.util.Scanner;

public class StudyDoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char a;
        do {
            System.out.println("是否还钱（y/n）：");
            a = scanner.next().charAt(0);
        } while (a != 'y');
        System.out.println("算你识相！！！");

    }
}
