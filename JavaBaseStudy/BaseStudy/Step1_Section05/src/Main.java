import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*a~d小写转大写，其他输出错误*/
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入a或者b单个字符:");
        char n1 = scanner.next().charAt(0); //该语句是下面两句语句的简写
        /*String n0 = scanner.next();
        char n1 = n0.charAt(0);*/
        switch (n1) {
            case 'a' :
                n1 = (char)(n1-32);
                System.out.println("n1="+n1);
                break;
            case 'b' :
                n1 -= 32;
                n1 = (char)n1;
                System.out.println("n1="+n1);
                break;
            default:
                System.out.println("输入的字符并非a或者b");
        }


    }
}