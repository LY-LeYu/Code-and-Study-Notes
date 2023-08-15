import java.util.Scanner;
public class ArrayAdd {
    public static void main(String[] args) {
        int[] ARR1 = {1, 2, 3};
        System.out.println("数组此时数据为:");
        for (int j = 0; j < ARR1.length; j++) {
            System.out.print(ARR1[j]+"\t");
        }
        do {
            int[] arrNew = new int[ARR1.length + 1];
            for (int i = 0; i <= ARR1.length - 1; i++) {
                arrNew[i] = ARR1[i];
            }
            System.out.print("\n请输入要添加到数据：");
            Scanner scanner = new Scanner(System.in);
            arrNew[ARR1.length] = scanner.nextInt();
            ARR1 = arrNew;
            System.out.print("是否继续添加数据？（Y/N）");
            char flag = scanner.next().charAt(0);
            if (flag == 'N') {
                System.out.println("添加完毕，数组此时数据为:");
                for (int j = 0; j < ARR1.length; j++) {
                    System.out.print(ARR1[j]+"\t");
                }
                break;
            }

        } while (true);

    }
}