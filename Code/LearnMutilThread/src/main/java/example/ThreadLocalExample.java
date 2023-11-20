package example;

public class ThreadLocalExample {
    // 创建一个ThreadLocal变量
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        // 创建两个线程
        Thread thread1 = new Thread(() -> {
            threadLocalValue.set(1);
            System.out.println("Thread 1: " + threadLocalValue.get()); // 输出 1
        });

        Thread thread2 = new Thread(() -> {
            threadLocalValue.set(2);
            System.out.println("Thread 2: " + threadLocalValue.get()); // 输出 2
        });

        thread1.start();
        thread2.start();
    }
}
