import java.util.Arrays;

public class MergeSort {
    //归并排序
    public static int[] sort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }
        int[] arr1 = Arrays.copyOfRange(arr, 0, len / 2);
        int[] arr2 = Arrays.copyOfRange(arr, len / 2, len);
        return merge2(sort(arr1), sort(arr2));

    }
    public static int[] merge(int[] arr_1, int[] arr_2) {
        int[] sorted_arr = new int[arr_1.length + arr_2.length];
        int idx = 0, idx_1 = 0, idx_2 = 0;
        while (idx_1 < arr_1.length && idx_2 < arr_2.length) {
            if (arr_1[idx_1] < arr_2[idx_2]) {
                sorted_arr[idx] = arr_1[idx_1];
                idx_1 += 1;
            } else {
                sorted_arr[idx] = arr_2[idx_2];
                idx_2 += 1;
            }
            idx += 1;
        }
        if (idx_1 < arr_1.length) {
            while (idx_1 < arr_1.length) {
                sorted_arr[idx] = arr_1[idx_1];
                idx_1 += 1;
                idx += 1;
            }
        } else {
            while (idx_2 < arr_2.length) {
                sorted_arr[idx] = arr_2[idx_2];
                idx_2 += 1;
                idx += 1;
            }
        }
        return sorted_arr;
    }
    public static int[] merge2(int[] arr1, int[] arr2){
        int[] res = new int[arr1.length + arr2.length];
        int index1 = 0,index2 = 0;
        for (int i = 0; i < res.length; i++) {
            if(index1 < arr1.length && index2 < arr2.length){
                if( arr1[index1] < arr2[index2]){
                    res[i] = arr1[index1];
                    index1++;
                }else{
                    res[i] = arr2[index2];
                    index2++;
                }
            }else{
                if(index1 < arr1.length){
                    res[i] = arr1[index1++];
                }
                if(index2 < arr2.length){
                    res[i] = arr2[index2++];
                }
            }

        }
        return res;
    }
}
