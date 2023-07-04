public class HomeWork05 {
    public static void main(String[] args) {
        int flag = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 5 != 0) {
                flag++;
                System.out.print(i+"\t");
            }
            if (flag == 5) {
                System.out.print("\n");
                flag = 0;
            }
        }
    }
}
