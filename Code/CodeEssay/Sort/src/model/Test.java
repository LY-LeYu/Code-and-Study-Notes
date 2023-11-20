package model;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //手动输入测试数据
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextInt()){
//            int num = scanner.nextInt();
//            if(num == 0) break;
//            int[] arr = new int[num];
//            for(int i = 0; i < num; i++){
//                arr[i] = scanner.nextInt();
//            }
//            Sort.bubbleSort(arr);
//            Sort.selectionSort(arr);
        //随机生成数据
        Random rd = new Random();
        int num = 10;
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(100) + 1;
        }
        System.out.print("测试数据：");
        System.out.println(Arrays.toString(arr));

//        model.QuickSort.sort2(arr, 0, num - 1);
//        int[] sort = model.MergeSort.sort(arr);
        int[] sort = HeapSort1.sort(arr);
        System.out.print("排序后：");
        System.out.println(Arrays.toString(sort));



//    }

    }
}
