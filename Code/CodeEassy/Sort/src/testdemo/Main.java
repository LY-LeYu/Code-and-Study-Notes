package testdemo;


import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("未排序数组："+Arrays.toString(arr));


//        int[] sort = BubbleSort.sort(arr);
//        int[] sort = SelectionSort.sort(arr);
//        int[] sort = InsertionSort.sort(arr);
        int[] sort = ShellSort.sort(arr);
//        int[] sort = selftesting.MergeSort.sort(arr);
//        int[] sort = selftesting.QuickSort.sort(arr);
//        int[] sort = selftesting.HeapSort.sort(arr);

        System.out.println("排序后数组："+Arrays.toString(sort));

    }
}
