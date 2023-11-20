package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class ZeroOneQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int[] arr1 = new int[M];
            int[] arr2 = new int[M];
            for (int i = 0; i < M; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < M; i++) {
                arr2[i] = sc.nextInt();
            }
//            System.out.println(M + " " + N);
//            System.out.println(Arrays.toString(arr1));
//            System.out.println(Arrays.toString(arr2));

            int res = func(M,N,arr1,arr2);
            System.out.println(res);
        }
    }

    private static int func(int m, int n, int[] arr1, int[] arr2) {
        int[][] dp = new int[m][n + 1];

        for (int i = 0; i <= n; i++) {
            if(i >= arr1[0])
                dp[0][i] = arr2[0];
        }

        for (int i = 1; i < m ; i++) {
            for (int j = 1; j <= n; j++) {
                if(j < arr1[i]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr1[i]] + arr2[i]);
                }
            }
        }
        //da
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[m-1][n];
    }
}
