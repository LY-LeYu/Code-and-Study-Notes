public class BubbleSort {
    public static int[] sort(int[] arr) {
        int len = arr.length;
        boolean flag = true;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i ; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }

        }
        return arr;
    }
}
