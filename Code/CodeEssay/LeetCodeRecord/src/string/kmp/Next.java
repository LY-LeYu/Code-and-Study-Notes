package string.kmp;

public class Next {
    public static int[] getNextArr(String str) {
        //初始化
        char[] x = str.toCharArray();
        int[] next = new int[x.length];
        next[0] = 0;
        int j = 0; //j指向前缀末尾，同时可以表示最大相同前后缀长度
        //开始求字符串的前缀表
        for (int i = 1; i < x.length; i++) { //i指向后缀的末尾
            //当字符串前后缀不相等时，j回退至next数组对应位置,直至j回退到0
            while (j > 0 && x[i] != x[j]) {
                j = next[j - 1];
            }
            //当前后缀相等时，记录此时j的值，表示为前后缀相等的最大长度
            if (x[i] == x[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
