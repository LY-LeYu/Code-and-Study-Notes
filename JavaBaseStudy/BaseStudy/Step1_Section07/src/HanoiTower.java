public class HanoiTower {
    public static void main(String[] args) {
        Tower T = new Tower();
        T.move('A', 'B', 'C',3 );
    }
}

class Tower {
    public void move(char a, char b, char c, int n) {
        if (n == 1) {
            System.out.println(a + "->" + c);
        } else {
            move(a,c,b,n-1);
            System.out.println(a + "->" + c);
            move(b,a,c,n-1);
        }
    }
}
