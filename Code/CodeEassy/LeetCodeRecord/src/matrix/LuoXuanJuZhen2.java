package matrix;

import java.util.Arrays;

public class LuoXuanJuZhen2 {
    public static void main(String[] args) {
        int[][] arr = func(5);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }
    private static int[][] func(int n) {
        int[][] arr = new int[n][n];
        int loop = n / 2;
        int count = 1;
        for (int i = 0; i < loop; i++) {
            int row = i, col = i;
            for (; col < n - i - 1; col++) {
                arr[row][col] = count++;
            }
            for (; row < n - i - 1; row++) {
                arr[row][col] = count++;
            }
            for (; col > i; col--) {
                arr[row][col] = count++;
            }
            for (; row > i; row--) {
                arr[row][col] = count++;
            }

        }
        if(n % 2 != 0){
            arr[n/2][n/2] = count++;
        }



        return arr;
    }
}
