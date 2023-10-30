package example;

/**
 * 简单演示死锁的代码
 */

public class DeadLockExample {
//    private static final Object o1 = new Object();
//    private static final Object o2 = new Object();

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        new Thread(()->{
            synchronized (o1) {
                try {
                    System.out.println(Thread.currentThread().getName() + "拥有资源o1");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"等待资源o2");
                synchronized (o2){
                    System.out.println("Complete");
                }
            }


        },"线程1").start();

        new Thread(()->{
            synchronized (o2) {
                try {
                    System.out.println(Thread.currentThread().getName() + "拥有资源o2");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"等待资源o1");
                synchronized (o1){
                    System.out.println("Complete");
                }
            }
        },"线程2").start();
    }
}
