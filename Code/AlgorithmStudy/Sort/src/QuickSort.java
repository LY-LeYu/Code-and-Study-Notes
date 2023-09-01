public class QuickSort {
    //快速排序
    public static void sort1(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = arr[high];
        int pointer = low;
        for (int i = low; i < high; i++){
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[pointer];
                arr[pointer] = temp;
                pointer++;
            }
        }
        int temp = arr[pointer];
        arr[pointer] = arr[high];
        arr[high] = temp;

        sort1(arr, low, pointer - 1);
        sort1(arr, pointer + 1, high);
    }

    public static void sort2(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        //选取基准数
        int val =arr[low];
        int left = low;
        int right = high;
        while(left < right){//当l >= r时，就是调整完成时
            //从后往前找第一个小于val的数字
            while (left < right && arr[right] > val){
                right --;
            }
            if(left < right)
                arr[left++] = arr[right];
            //从前往后找第一个大于val的数字
            while (left < right && arr[left] < val){
                left++;
            }
            if(left < right)
                arr[right--] = arr[left];
        }
        //left==right,基准数放进去
        arr[left] = val;
        sort2(arr,low, left -1);
        sort2(arr, left +1,high);
    }
}
