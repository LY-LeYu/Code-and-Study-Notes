package thread_;

import java.util.Scanner;

public class ClassWork01 {
    public static void main(String[] args) {
        A a = new A();

        new Thread(a).start();

        new Thread(new B(a)).start();

    }
}

class A implements Runnable {
    boolean flag = true;
    int i = 0;
    @Override
    public void run() {
        while (flag) {
                System.out.println(Thread.currentThread().getName() + "打印整数" + (i++));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
        if (flag = false) {
            System.out.println(Thread.currentThread().getName() + "已结束");
        }
    }

}

class B implements Runnable {
    A a;
    Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    public void run() {
        while (true) {
            System.out.println("输入指令（Q/q）中止输出：");
            char inputstr = scanner.next().charAt(0);
            if (inputstr == 'q' || inputstr == 'Q') {
                a.flag = false;
                System.out.println(Thread.currentThread().getName()+"已退出");
                break;
            }

        }
    }
}

