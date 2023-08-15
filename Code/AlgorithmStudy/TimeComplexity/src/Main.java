import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] arr = {1, 2, 2};
        test(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    static void test(int[] arr1) {
        arr1[1]  = 10;
    }
}