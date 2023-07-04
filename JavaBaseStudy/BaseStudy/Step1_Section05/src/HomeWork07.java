public class HomeWork07 {
    public static void main(String[] args) {
        double sum = 0;
        for (double i = 1; i <= 100; i++) {  //注意这里的i不要用成int类型，或者将1/i改成1.0
            sum += 1 / i * Math.pow(-1, i - 1);
        }
        System.out.println("合为："+sum);
    }
}
