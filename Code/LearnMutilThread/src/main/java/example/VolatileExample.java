package example;

public class VolatileExample {
    private volatile boolean flag = false;
//    private boolean flag = false;

    public void toggleFlag() {
        flag = !flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            example.toggleFlag();
            System.out.println("Flag has been set to true.");
        });

        Thread readerThread = new Thread(() -> {
            while (!example.isFlag()) {
                // 等待直到flag为true
            }
            System.out.println("Flag is true, exiting.");
        });

        writerThread.start();
        readerThread.start();
    }
}
