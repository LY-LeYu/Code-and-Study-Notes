package homework;

import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        str = scanner.next();
        str = reverse(str,0,str.length()-1);
        System.out.println(str);
    }

    public static String reverse(String str, int start, int end) {
        char[] a = str.toCharArray();
        char temp;
        for (int i = start, j = end;i<j; i++,j--) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        str = new String(a);
        return str;
    }

}
