import com.sun.org.apache.xpath.internal.operations.String;

public class SelectionSort {

    //选择排序
    public static int[] sort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }

        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }
}
