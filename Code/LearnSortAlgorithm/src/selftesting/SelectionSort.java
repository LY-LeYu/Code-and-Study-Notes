package selftesting;

public class SelectionSort {
    public static int[] sort(int[] arr) {
        int minIndex ;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }
}
