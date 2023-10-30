package string.kmp;

import java.util.Scanner;

public class PatternMatching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入初始字符串");
        String str1 = scanner.next();
        System.out.print("初始字符串为：" + str1);
        System.out.println();

        System.out.println("请输入需要匹配的子串");
        String str2 = scanner.next();
        System.out.print("子串为：" + str2);
        System.out.println();

        int[] next = Next.getNextArr(str2);
        System.out.print("Next数组为：");
        for (int num : next) {
            System.out.print(num);
        }
        System.out.println();

//        match(str1, str2); //朴素匹配方式
        matchUseNext(str1,str2,next); //KMP算法

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
        int i = 0, j = 0;
        for(; i < str1.length();i++){
            //字符串不匹配时
            while(j>0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j - 1];
            }
            //字符串匹配时
            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if(j == str2.length()){
                System.out.println("字符串匹配成功，子串位于母串下标为"+(i - j + 1)+"的位置");
                return;
            }
        }
        System.out.println("匹配失败！");
    }


}
