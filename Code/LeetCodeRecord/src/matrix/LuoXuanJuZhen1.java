package matrix;

import java.util.ArrayList;
import java.util.List;

public class LuoXuanJuZhen1 {
    public static void main(String[] args) {
        int[][] arr = { {1,2,3},{4,5,6},{7,8,9} };
        List<Integer> res = spiralOrder(arr);
        System.out.println(res);
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;//定义矩阵边界
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                res.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            //判断矩阵不是n*1或者1*n的，防止重复打印
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    res.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;

    }
}
