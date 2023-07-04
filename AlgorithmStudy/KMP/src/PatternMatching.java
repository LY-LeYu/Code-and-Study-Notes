import java.util.Scanner;

public class PatternMatching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入初始字符串");
//        String str1 = scanner.next();
        String str1 = "ababababababababc";
        System.out.print("初始字符串为：" + str1);
        System.out.println();

        System.out.println("请输入需要匹配的子串");
//        String str2 = scanner.next();
        String str2 = "asdfasdfasdf";
        System.out.print("子串为：" + str2);
        System.out.println();

        int[] next = Next.getNextArr(str2);
        System.out.print("Next数组为：");
        for (int num : next) {
            System.out.print(num);
        }
        System.out.println();
        Next.getNextArr2(str2);

//        match(str1, str2); //朴素匹配方式
//        matchUseNext(str1,str2,next); //KMP算法

        //比较两种方法所需要计算的时间
        /*long l1 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            match(str1, str2); //朴素匹配方式
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);

        long l11 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            matchUseNext(str1,str2,next); //KMP算法
        }
        long l22 = System.currentTimeMillis();
        System.out.println(l22-l11);*/


    }

    static void match(String str1, String str2) {
        char[] x = str1.toCharArray();
        char[] y = str2.toCharArray();
        int i = 0, j = 0;
        while (i <= x.length && j <= y.length) {
            if (x[i] == y[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j >= y.length) {
//                System.out.println("匹配成功！" + "字串位于初始串的第" + (i - j + 1) + "-" + i + "个位置");

                break;
            }
        }

    }

    static void  matchUseNext(String str1, String str2,int[] next) {
        char[] x = str1.toCharArray();
        char[] y = str2.toCharArray();
        int i = 0, j = 0;
        while (i <= x.length && j <= y.length) {
            if (j == 0 || x[i] == y[j]) {
                i++;
                j++;
            }else{
                //区别在于i不用向前移动，j恢复到next数组指定的位置
                j = next[j-1];
            }
            if (j >= y.length) {
//                System.out.println("KMP匹配成功！" + "字串位于初始串的第" + (i - j + 1) + "-" + i + "个位置");

                break;
            }
        }
    }


}
