public class Homework04 {
    public static void main(String[] args) {
        A03 a03 = new A03();
        int[] arr1 = {1, 2, 3, 5, 6, 7};
        a03.showArr(arr1);
        int[] arr2 = a03.copyArr(arr1);
        System.out.println("\n下面是拷贝的数组");
        a03.showArr(arr2);
    }
}

class A03 {
    public int[] copyArr(int[] arr) {
        int[] copyarr = new int[arr.length];
        for (int i = 0;i<arr.length;i++) {
            copyarr[i] = arr[i];
        }
        return copyarr;
    }

    public void showArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
