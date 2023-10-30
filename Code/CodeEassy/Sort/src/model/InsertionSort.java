package model;

public class InsertionSort {
    //插入排序
    public static int[] sort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }
        for (int i = 1; i < len; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex -= 1;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    //希尔排序
    public static int[] shellSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }
        int gap = len / 2; //设置增量
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int current = arr[i];
                int preIndex = i - gap;
                // Insertion sort
                while (preIndex >= 0 && current < arr[preIndex]) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = current;
            }
            gap /= 2;
        }
        return arr;
    }
}
