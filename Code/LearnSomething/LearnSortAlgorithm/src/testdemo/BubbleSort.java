package testdemo;

public class BubbleSort {
    public static int[] sort(int[] arr) {
        int len = arr.length;
        boolean isOrder = true;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isOrder = false;
                }
            }
            if (isOrder){
                break;
            }
        }
        return arr;
    }
}
