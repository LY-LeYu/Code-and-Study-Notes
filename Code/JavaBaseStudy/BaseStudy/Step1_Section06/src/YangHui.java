import java.util.Scanner;

public class YangHui {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入杨辉三角的行数：");
        int NUM = scanner.nextInt();
        //初始化二维数组
        int[][] YH;
        //确定行数
        YH = new int[NUM][];
        for (int i = 0; i < NUM; i++) {
            //确定每一行对应多少列
            YH[i] = new int[i + 1];
            //开始赋值
            for (int j = 0; j < i + 1; j++) {
                //开头和结尾为1
                if (j == 0 || j == i) {
                    YH[i][j] = 1;
                } else {
                    YH[i][j] = YH[i - 1][j] + YH[i - 1][j - 1]; //其余位置值的规则
                }
            }
        }
        //输出杨辉三角
        for (int[] i : YH) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.print("\n");
        }
    }
}
