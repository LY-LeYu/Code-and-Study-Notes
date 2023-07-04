import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*byte a = 1;
        a += 1;
        a = (byte) (a+1);*/
        /*输入语句*/
        System.out.println("Please Input Something：");
        String Input = scanner.next();
        System.out.println("你输入的是："+Input);
        /*字符串转相应的数值类型*/
        int n1 = Integer.parseInt("123");
        double n2 = Double.parseDouble("1.23");
        /**/
    }
}