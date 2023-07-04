public class OverLoad {
    public static void main(String[] args) {
        calculate cal = new calculate();
        int sum = cal.sum(1, 2, 3, 4, 5, 6);
        System.out.println(sum);
    }
}

class calculate {
    public int sum(int... parameters) {
        int sum = 0;
        for (int i : parameters) {
            sum += i;
        }
        return sum;
    }

}