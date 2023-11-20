package selftesting;

public class ShellSort {
    public static int[] sort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int cur = arr[i];
                int pre = i - gap;
                while (pre >= 0 && cur < arr[pre]) {
                    arr[pre + gap] = arr[pre];
                    pre -= gap;
                }
                arr[pre + gap] = cur;
            }
            gap /= 2;
        }


        return arr;
    }
}
