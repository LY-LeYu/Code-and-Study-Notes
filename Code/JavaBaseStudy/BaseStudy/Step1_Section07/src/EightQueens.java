public class  EightQueens {
    public static void main(String[] args) {
        int[] arr = new int[8];
        Queen Q = new Queen();
        Q.set(arr, 0);

    }
}
class Queen {
    public void set(int[] arr, int r) {
        if (r == 8) {
            printArr(arr);

        } else {
            for (int i = 0; i < 8; i++) {
                arr[r] = i;
                if (Test(arr, r)) {
                    set(arr, r + 1);
                }
            }
        }
    }
    public boolean Test(int[] arr, int n) {
        // Math.abs(n - i) == Math.abs(array[i] - array[n]) 代表在一条斜线上，数组下标之差等于列号的差
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[i] - arr[n])) {
                return false;
            }
        }
        return true;
    }
    public void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.print("\n");
    }
}
