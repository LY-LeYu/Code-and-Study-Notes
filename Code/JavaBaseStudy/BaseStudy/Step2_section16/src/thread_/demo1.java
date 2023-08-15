package thread_;

public class demo1 {
    public static void main(String[] args) {
//        Runtime runtime = Runtime.getRuntime();
//        int cpucore = runtime.availableProcessors();
//        System.out.println(cpucore);
        Test test = new Test();
//        test.run();//注意当使用run方法时，并未开启线程，程序先执行方法，再继续main方法
        test.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class Test extends Thread {
    int i = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println(i+++"线程"+Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 10) {
                break;
            }
        }
    }

}

