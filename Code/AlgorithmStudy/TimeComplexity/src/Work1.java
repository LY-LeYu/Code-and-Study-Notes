public class Work1 {
    public static void main(String[] args) {
        int x = 2, n = 5;
        System.out.println(function1(x,n));
    }

    static int function1(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return x;
        }
        int temp = function1(x,n / 2) ;

        if (n % 2 == 1) {
            return temp * temp * x;
        } else {
            return temp * temp;
        }

    }
}
