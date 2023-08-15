package backtracking;

import java.util.ArrayList;
import java.util.List;

//数字组合求和
public class Problem2 {
    static List<Integer> path = new ArrayList();
    static List<List<Integer>> result = new ArrayList();

    public static void main(String[] args) {
        backtracking(9, 2, 0, 8, 1);
        System.out.println(result);
    }

    public static void backtracking(int n, int k, int sum, int targetSum, int index) {
        if (sum > targetSum) {
            return;
        }
        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        } else {

            for (int i = index; i <= n; i++) {
                sum += i;
                path.add(i);
//                backtracking(n, k, sum, targetSum, index + 1);//经典错误，会导致组合相同
                backtracking(n, k, sum, targetSum, i + 1);//
                sum -= i;
                path.remove(path.size() - 1);
            }

        }
    }
}
