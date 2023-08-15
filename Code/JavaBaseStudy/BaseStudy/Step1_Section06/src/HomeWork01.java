public class HomeWork01 {
/**
 * 在一个有序数组内插入一个数
 * 我的思路，先插入在末尾，再排序
 * 其他思路：先查找位置，再插入
 */
    public static void main(String[] args) {
        int[] ARR = {10, 12, 45, 90};


        int num = 100;
        int[] arrNew = new int[ARR.length + 1];

//      数组增加
        for (int i = 0; i < arrNew.length; i++) {
            if (i < ARR.length) {
                arrNew[i] = ARR[i];
            } else {
                arrNew[i] = num;
            }
        }
//        数组排序
        int temp;
        for (int i = 0; i < arrNew.length; i++) {
            for (int j = 0; j < arrNew.length - i - 1; j++) {
                if (arrNew[j] > arrNew[j + 1]) {
                    temp = arrNew[j];
                    arrNew[j] = arrNew[j + 1];
                    arrNew[j + 1] = temp;
                }
            }
        }
        ARR = arrNew;
        for (int i : ARR) {
            System.out.print(i + "\t");
        }
    }
}
