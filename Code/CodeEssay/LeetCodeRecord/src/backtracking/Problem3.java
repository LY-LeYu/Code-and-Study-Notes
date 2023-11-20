package backtracking;

import java.util.ArrayList;

//同一集合，数字组合求和 数字可重复，组合不可重复
public class Problem3 {
    static ArrayList<Integer> path = new ArrayList();
    static ArrayList<ArrayList<Integer>> result = new ArrayList();

    public static void main(String[] args) {
//        int[] arr = {10,1,2,7,6,1,5};
        int[] arr = {2,3,5};
        backtracking(arr, 0, 8,  0);
        System.out.println(result);
    }

    public static void backtracking(int[] n,  int sum, int targetSum, int index) {
        if (sum > targetSum) {
            return;
        }
        if (sum == targetSum) {
            result.add(new ArrayList<>(path));
        } else {
            for (int i = index; i < n.length  ; i++) { //可以通过剪枝优化，如下所示
//            for (int i = index; i < n.length && sum+n[index] <= targetSum ; i++) {
                sum += n[i];
                path.add(n[i]);
                backtracking(n, sum, targetSum, i);
                sum -= n[i];
                path.remove(path.size() - 1);
            }

        }
    }
}
