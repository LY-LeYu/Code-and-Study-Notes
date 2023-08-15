package backtracking;


import java.util.ArrayList;
import java.util.Arrays;

//同一集合中 数字组合求和，可重复，组合不重复
public class Problem4 {
    static ArrayList<Integer> path = new ArrayList();
    static ArrayList<ArrayList<Integer>> result = new ArrayList();

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(arr);
//        arrSort(arr);
        boolean[] used = new boolean[arr.length];
        backtracking(arr, used, 0, 8, 0);
        System.out.println(result);
    }

    public static void backtracking(int[] arr, boolean[] used, int sum, int targetSum, int index) {
        if (sum > targetSum) {
            return;
        }
        if (sum == targetSum) {
            result.add(new ArrayList<>(path));
            return;
        }
//        for (int i = index; i < arr.length; i++) {
        for (int i = index; i < arr.length && sum + arr[i] <= targetSum; i++) {
            if (i > 0 && arr[i] == arr[i - 1] && used[i -1] == false) {
                continue;
            }
            sum += arr[i];
            used[i] = true;
            path.add(arr[i]);
            backtracking(arr, used, sum, targetSum, i + 1);
            used[i] = false;
            sum -= arr[i];
            path.remove(path.size() - 1);
        }


    }

//    public static int[] arrSort(int[] arr) {
//        int temp = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[i]) {
//                    temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
//                }
//            }
//
//        }
//
//        return arr;
//    }

}
