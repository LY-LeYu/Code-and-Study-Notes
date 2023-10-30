package testdemo;

public class InsertionSort {
    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int pre = i - 1;
            int cur = i;
            int temp = arr[cur];
            while (pre >= 0 && temp < arr[pre]) {
                arr[pre + 1] = arr[pre];
                pre--;
            }
            arr[pre + 1] = temp;
        }
        return arr;
    }
}
