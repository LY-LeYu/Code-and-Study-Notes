import java.util.Random;
import java.util.Scanner;

/*和电脑玩石头剪刀布
0代表石头
1代表剪刀
2代表布
* */
public class HomeWork14 {
    public static void main(String[] args) {
        String[][] x = new String[3][3];
        Scanner scanner = new Scanner(System.in);
        System.out.println("比赛为三局两胜制：\n0代表石头\n" + "1代表剪刀\n" + "2代表布");
        for (int i = 0; i < 3; i++) {
            int j=0;
            System.out.print("输入0或1或2：");
            int num = scanner.nextInt();
            play p = new play(num);
            x[i][j] = p.pcNum+"";
            x[i][j+1] = p.peopleNum+"";
            x[i][j+2] = p.winOrLoss();
            System.out.println("电脑出的是"+p.pcNum+",猜拳结果是："+x[i][j+1]);

        }

        System.out.println("最终的结果为：");
        System.out.println("电脑出拳\t玩家出拳\t胜负");
        for (String[] i : x) {
            for (String j:i) {
                System.out.print(j+"\t\t");
            }
            System.out.println();

        }


    }
}


class play {
    int pcNum;
    int peopleNum;
    public play(int peopleNum) {
        this.pcNum = new Random().nextInt(3);
        this.peopleNum = peopleNum;
    }

    public String winOrLoss() {
        if (peopleNum - this.pcNum == 1 || peopleNum - this.pcNum == -2) {
            return "loss";
        } else if (peopleNum - this.pcNum == -1 || peopleNum - this.pcNum == 2) {
            return "win";
        } else {
            return "GoOn";
        }
    }

}