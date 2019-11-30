package multithread.threadPool;


import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * @description: 线程池ForkJoinPool的使用，继承RecursiveAction实现（无返回值的Task），线程数一般等于CPU核数
 *                 执行没有返回值的"大任务"（简单的打印0~300的数值），将一个"大任务"拆分成多个"小任务"，并将任务交给ForkJoinPool来执行
 *                 使用递归实现任务的拆分
 * @author: Jingyuankui
 * @time: 2019/11/30 14:39
 */
public class ForkJoinPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        Date startTime = new Date();
        // 提交一个可分解的PrintTask任务
        pool.submit(new PrintTask(0,300));
        //pool.submit(new PrintTask(0,10000000));  用于验证awaitTermination方法

        // 线程池的有效执行时间（此方法会阻塞，通常与shutdown()方法一起用）：当线程池执行2s及以上，往下走，进行shutdown()；
        // 线程池运行的时候，程序阻塞在这个方法
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();

    }
}

/**
 * 继承RecursiveAction来实现"可分解"的任务
 */
class PrintTask extends RecursiveAction {
    // 每个"小任务"最多只能打印50个数
    private static final int THRESHOLD = 50;
    private int start;
    private int end;

    // 打印从start到end的任务
    public PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        // 当end-start < THRESHOLD 时，开始打印
        if (end-start < THRESHOLD) {
            // 这里因为是<end所以不包含end
            for (int i=start; i<end; i++) {
                System.out.println(Thread.currentThread().getName()+"的i值："+i);
            }
        } else {
            // 当end-start > THRESHOLD 时（要打印的数超过50时），拆分为两个"小任务"
            int middle = (start+end)/2;
            PrintTask left = new PrintTask(start,middle);
            PrintTask right = new PrintTask(middle,end);

            // 并行执行两个"小任务"，分解后的任务分别调用fork方法开始并行执行
            left.fork();
            right.fork();
        }
    }
}