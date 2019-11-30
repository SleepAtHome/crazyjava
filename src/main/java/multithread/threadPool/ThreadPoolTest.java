package multithread.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 使用线程池来执行线程任务
 * @author: Jingyuankui
 * @time: 2019/11/30 13:58
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 创建一个具有固定6个线程的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(6);

        // 向线程池中提交两个线程
        threadPool.submit(new JYKThreadpoolTestThread());
        threadPool.submit(new JYKThreadpoolTestThread());

        // 关闭线程池
        threadPool.shutdown();
    }
}

/**
 * 线程池专用Thread
 */
class JYKThreadpoolTestThread implements Runnable {

    @Override
    public void run() {
        for (int i=0; i<1000; i++) {
            System.out.println(Thread.currentThread().getName()+"的i值为："+i);
        }
    }
}
