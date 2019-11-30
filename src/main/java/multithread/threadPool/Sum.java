package multithread.threadPool;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @description: 线程池ForkJoinPool的使用，继承RecursiveTask实现（有返回值的Task）
 *                 执行有返回值的"大任务"（对一个长度为100的数组进行累加）
 * @author: Jingyuankui
 * @time: 2019/11/30 17:06
 */
public class Sum {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] jykArr = new int[100];
        Random random = new Random();
        int total = 0;

        for (int a=0; a<jykArr.length; a++) {
            int tmp = random.nextInt();
            // 对数组元素进行赋值，并用total计算出这个数组的值的总和
            total += (jykArr[a]=tmp);
        }
        System.out.println("数组元素的总和为：" + total);

        ForkJoinPool pool = new ForkJoinPool();
        Future<Integer> future = pool.submit(new CalTask(jykArr, 0, jykArr.length));
        System.out.println("使用ForkJoinPool计算的总和为"+future.get());
        pool.shutdown();
    }
}

/**
 * 继承RecursiveTask来实现"可分解"的任务（有返回值）
 */
class CalTask extends RecursiveTask<Integer> {

    // 每个"小任务"最多只能累加20个数
    private static final int THRESHOLD = 20;
    private int[] arr;
    private int start;
    private int end;

    // 累加从start到end的数组元素
    public CalTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        // 当end-start < THRESHOLD 时，开始进行实际累加
        if (end-start < THRESHOLD) {
            for (int i=start; i<end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            int middle = (start+end)/2;
            CalTask left = new CalTask(arr,start,middle);
            CalTask right = new CalTask(arr,middle,end);

            left.fork();
            right.fork();

            // 合并两个"小任务"的结果
            return left.join() + right.join();
        }
    }
}
