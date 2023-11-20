package selftesting;

public class QuickSort1 {
    public static int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int left = start, right = end;
        int flag = arr[left];
        while (left < right) {
            while (left < right && arr[right] > flag)
                right--;
            if (left < right)
                arr[left++] = arr[right];
            while (left < right && arr[left] < flag)
                left++;
            if (left < right)
                arr[right--] = arr[left];
        }
        arr[left] = flag;
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

}
