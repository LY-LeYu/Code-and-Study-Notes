public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        float A;
        A = 1.1F;
        long B;
        B = 7000000000L;
        //浮点数计算陷阱，最好不要对运算结果是小数的进行相等判断
        float C = 8.1f / 3f;
        double D = 8.1 / 3;
        short E = 127;
        float a = 1.1F;
        long b = 1;
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
    }
}