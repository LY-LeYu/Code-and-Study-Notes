package backtracking;

import java.util.Scanner;

public class Nqueen {
    static int num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        find(arr, 0);
        System.out.println(num);
    }

    public static void find(int[] arr, int index) {

        if (index == arr.length) {
            num++;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[index] = i;
            boolean flag = false;
            for (int j = index - 1; j >= 1; j--) {
                if (arr[index] != arr[j] || Math.abs(arr[index] - arr[j]) != 1) {
                    flag = true;
                }
            }
            if (flag) {
                find(arr, index + 1);
            }
        }


    }

}
