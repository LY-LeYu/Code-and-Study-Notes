package selftesting;

public class InsertionSort {
    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int pre = i - 1;
            while (pre >= 0 && cur < arr[pre]) {
                arr[pre + 1] = arr[pre];
                pre--;
            }
            arr[pre + 1] = cur;
        }
        return arr;
    }
}
