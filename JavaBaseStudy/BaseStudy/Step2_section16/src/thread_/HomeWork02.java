package thread_;

import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        Bank bank = new Bank(100);
        new Thread(bank).start();
        new Thread(bank).start();
    }

}

class Bank implements Runnable {
    private double money;
    Scanner sc = new Scanner(System.in);


    public Bank(double money) {
        setMoney(money);
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public  void  run() {
        while (true) {
            if (this.money <= 0) {
                System.out.println(Thread.currentThread().getName()+"取钱失败,账户余额为零");
                break;
            }
            useMoney();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public synchronized void useMoney() {
        System.out.println(Thread.currentThread().getName()+"正在取款");
//        double money = sc.nextDouble();
        this.money-= 10;
        System.out.println("当前余额为" + this.money);
    }
}
