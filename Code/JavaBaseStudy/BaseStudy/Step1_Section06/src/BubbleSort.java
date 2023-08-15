public class BubbleSort {
    public static void main(String[] args) {
        int[] arr1 = {34, 56, 68, 56, 99, 50};
        System.out.println("未排序数组为：");
        for (int i : arr1) {
            System.out.print(i + "\t");
        }
        int temp;
        int flag = 1;
        for (int i = arr1.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                }
            }
            System.out.println("\n第" + flag + "轮排序后数组为：");
            for (int k : arr1) {
                System.out.print(k + "\t");
            }
            flag++;
        }

    }
}
