package thread_;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Test2 test2 = new Test2();
        Thread thread = new Thread(test2);
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+i);
            Thread.sleep(1000);
            if (i == 5) {
                thread.start();
                thread.join();
            }
        }

    }
}

class Test2 implements Runnable {
    int i;
    @Override
    public void run() {
        while (true) {
            System.out.println("线程："+Thread.currentThread().getName()+"输出"+(i++));
            try {
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 10) {
                break;
            }
        }

    }

}
