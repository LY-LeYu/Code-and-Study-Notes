import java.util.Arrays;

public class QuickSort {
    public static int[] sort(int[] arr) {
        quickSort(arr,0,arr.length - 1);
        return arr;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low >= high){
            return;
        }
        //选取基准数
        int val = arr[low];
        int left = low;
        int right = high;
        while(left < right){//当l >= r时，就是调整完成时
            //从后往前找第一个小于val的数字
            while (left < right && arr[right] > val){
                right --;
            }
            if(left < right)
                arr[left] = arr[right];
            //从前往后找第一个大于val的数字
            while (left < right && arr[left] < val){
                left++;
            }
            if(left < right)
                arr[right] = arr[left];
        }
        //left==right,基准数放进去
        arr[left] = val;
        quickSort(arr,low, left -1);
        quickSort(arr, left +1,high);
    }
}
