package example;

import java.util.concurrent.*;

/**
 * 线程池必须手动通过 ThreadPoolExecutor 的构造函数来声明，避免使用Executors 类创建线程池，会有 OOM 风险。
 * Executors 返回线程池对象的弊端如下(后文会详细介绍到)：
 * FixedThreadPool 和 SingleThreadExecutor：使用的是无界的 LinkedBlockingQueue，任务队列最大长度为 Integer.MAX_VALUE,可能堆积大量的请求，从而导致 OOM。
 * CachedThreadPool：使用的是同步队列 SynchronousQueue, 允许创建的线程数量为 Integer.MAX_VALUE ，可能会创建大量线程，从而导致 OOM。
 * ScheduledThreadPool 和 SingleThreadScheduledExecutor : 使用的无界的延迟阻塞队列DelayedWorkQueue，任务队列最大长度为 Integer.MAX_VALUE,可能堆积大量的请求，从而导致 OOM。
 * 说白了就是：使用有界队列，控制线程创建数量。
 * 除了避免 OOM 的原因之外，不推荐使用 Executors提供的两种快捷的线程池的原因还有：
 * 实际使用中需要根据自己机器的性能、业务场景来手动配置线程池的参数比如核心线程数、使用的任务队列、饱和策略等等。
 * 我们应该显示地给我们的线程池命名，这样有助于我们定位问题。
 *
 */
public class ThreadPoolExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建一个固定大小的线程池
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        // 提交一个任务
        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName()+"线程执行的代码");
        });

        // 提交一个任务，并获取结果
        Future<Integer> future = threadPool.submit(() -> {
            System.out.println(Thread.currentThread().getName()+"线程执行的代码" );
            return 777;
        });
        System.out.println(future.get());

        // 提交多个任务，并获取结果
        for (int i = 1; i <= 10; i++) {
            final int taskNumber = i;
            Future<String> future1 = threadPool.submit(() -> {
                String result = "Task " + taskNumber + " executed by thread " + Thread.currentThread().getName();
                return result;
            });
            try {
                String result = future1.get(); // 获取任务的结果
                System.out.println("任务的结果：" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 提交多个任务
        /*Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println("任务在线程 " + threadName + " 中执行");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        };
        Callable task2 = () ->{
            for (int i = 0; i < 10; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println("任务2在线程 " + threadName + " 中执行");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return 1;
        };
        for (int i = 0; i < 5; i++) {
            threadPool.execute(task);
            threadPool.submit(task2);
        }*/



        threadPool.shutdown(); // 关闭线程池

    }

}
