package string.kmp;

import java.util.Arrays;

public class GetNext {
    public static void main(String[] args) {
        String str = "ababc";
        int[] next = findNext(str);
        System.out.println(Arrays.toString(next));

    }

    public static int[] findNext(String needle) {
        char[] charArray = needle.toCharArray();
        int[] arr = new int[needle.length()];
        arr[0] = 0;
        int i = 0, j = 1;
        for (; j < arr.length; j++) {
            while (i > 0 && charArray[i] != charArray[j]) {
                i = arr[i - 1];
            }
            if(charArray[i] == charArray[j]){
                i++;
            }
            arr[j] = i;
        }
        return arr;
    }
}
