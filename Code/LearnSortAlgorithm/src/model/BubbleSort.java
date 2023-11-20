package model;

import java.util.Arrays;

public class BubbleSort {
    //冒泡排序
    public static int[] sort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }
        int temp;
        boolean flag = true; //优化，如果本来就有序则直接结束
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }


}
