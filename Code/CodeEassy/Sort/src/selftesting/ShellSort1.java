package selftesting;

public class ShellSort1 {
    public static int[] sort(int[] arr){
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int pre = i - gap;
                int cur = arr[i];
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
