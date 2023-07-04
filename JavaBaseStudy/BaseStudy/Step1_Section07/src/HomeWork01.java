public class HomeWork01 {
    public static void main(String[] args) {
        A01 A = new A01();
        int max = A.max(new int[]{1, 2, 3, 4, 18, 6});
        System.out.println(max);

    }
}

class A01 {
    public int max(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
