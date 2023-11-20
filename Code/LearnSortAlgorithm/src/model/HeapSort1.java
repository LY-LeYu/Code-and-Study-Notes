package model;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort1 {

    public static int[] sort(int[] array) {
        // 创建一个最小堆,优先级队列默认最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 将数组中的元素添加到最小堆中
        for (int num : array) {
            minHeap.offer(num);
        }

        // 从最小堆中逐个取出元素，放入排序后的数组中
//        int index = 0;
//        while (!minHeap.isEmpty()) {
//            array[index++] = minHeap.poll();
//        }
        int size  = minHeap.size();
        for (int i = 0; i < size; i++) {
            array[i] = minHeap.poll();
        }
        return array;
    }

}