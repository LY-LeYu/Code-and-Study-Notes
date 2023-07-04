package backtracking;

import java.util.Vector;

//数字组合
public class Problem1 {
    static Vector<Vector<Integer>> result = new Vector<>();
    static Vector<Integer> path = new Vector<>();
    static int num = 0;

    public static void main(String[] args) {
        backtracking(4,4,1);
//        System.out.println(num);
        System.out.println(num);
        System.out.println(Problem1.result);

    }

    static void backtracking(int n, int k, int index) {
        if (path.size() == k) {
            result.addElement(new Vector<>(path)); //在添加对象时，由于path是static声明的，所以需要保存new的path对象
//            result.addElement(path); //不使用new的对象，则保存进result的path将被覆盖，错误详见https://blog.csdn.net/hyy_blue/article/details/93313754
            num++;
        } else {
            for (int i = index; i <= n -(k-path.size())+1 ; i++) {
                path.add(i);
                backtracking(n, k, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
