public class HomeWork01 {
    public static void main(String[] args) {
        double CASH = 100000;
        int flag = 0;
        while (true) {
            if (CASH > 50000) {
                CASH = CASH * 0.95;
            } else if (CASH <= 50000 && CASH >= 1000) {
                CASH -= 1000;
            } else {
                break;
            }
            flag++;
        }
        System.out.println("经过了"+flag+"个路口");
    }
}

