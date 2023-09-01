public class HeapSort {
    //堆排序

    // Global variable that records the length of an array;
    static int heapLen;

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }


    private static void heapify(int[] arr, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (right < heapLen && arr[right] > arr[largest]) {
            largest = right;
        }
        if (left < heapLen && arr[left] > arr[largest]) {
            largest = left;
        }
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, largest);
        }
    }


    public static int[] sort(int[] arr) {
        // index at the end of the heap
        heapLen = arr.length;
        // build MaxHeap
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            // Move the top of the heap to the tail of the heap in turn
            swap(arr, 0, i);
            heapLen -= 1;
            heapify(arr, 0);
        }
        return arr;
    }

}
