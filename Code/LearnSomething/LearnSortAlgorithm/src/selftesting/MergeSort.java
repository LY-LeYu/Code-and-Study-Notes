package selftesting;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] arr) {
        if(arr.length <= 1 ) return arr;
        int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] arr2 = Arrays.copyOfRange(arr, arr.length/2, arr.length);
        return merge(sort(arr1),sort(arr2));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        int[] res = new int[len];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < len; i++) {
            if(index1 < arr1.length && index2 < arr2.length){
                if (arr1[index1] <= arr2[index2]) {
                    res[i] = arr1[index1];
                    index1++;
                } else {
                    res[i] = arr2[index2];
                    index2++;
                }
            }else if(index1 < arr1.length) {
                res[i] = arr1[index1++];
            }else if (index2 < arr2.length) {
                res[i] = arr2[index2++];
            }
        }
        return res;

    }
}
