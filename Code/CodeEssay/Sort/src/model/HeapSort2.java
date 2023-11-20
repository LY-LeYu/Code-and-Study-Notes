package model;

public class HeapSort2 {
    private static int len; //用来标记堆排序的进度

    public static int[] sort(int[] arr) {
        len = arr.length;
        //构建大顶堆
        buildHeap(arr);

        //排序
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            len--;
            heapify(arr,0);
        }
        return arr;
    }

    private static void heapify(int[] arr, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIndex = i;
        if (left < len && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }
        if (right < len && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != i) {
            swap(arr, i, maxIndex);
            //此时maxIndex是交换后的节点，仍需判断以maxIndex为根节点的子树是否为大顶堆
            heapify(arr,maxIndex);
        }

    }

    private static void buildHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
