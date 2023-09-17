public class HeapSort {
    static int len;

    public static int[] sort(int[] arr) {
        //初始化数组长度
        len = arr.length;
        //构建大顶堆
        buildHeap(arr);
        //堆排序
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            len--;
            heapify(arr,0);
        }
        return arr;
    }

    private static void buildHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    private static void heapify(int[] arr, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int max = i;
        if(left < len && arr[left] > arr[max]){
            max = left;
        }
        if(right < len && arr[right] > arr[max]){
            max = right;
        }
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr, max);
        }
    }
}
