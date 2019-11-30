package multithread.newThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * ClassName: ThirdThread
 * Description: 通过实现Callable来实现多线程，这里的泛型指的是call()方法的返回值类型
 * date: 2019/11/9 0:17
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ThirdThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for ( ; i<100; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }

        // call()方法可以有返回值
        return i;
    }

    public static void main(String[] args) {

        ThirdThread tt = new ThirdThread();

        // 使用FutureTask对象来包装Callable对象(tt)
        FutureTask<Integer> task = new FutureTask<Integer>(tt);

        for (int a=0; a<100; a++) {
            System.out.println(Thread.currentThread().getName()+"=="+a);

            if (20 == a) {
                // 事实上还是以Callable对象来创建并启动线程
                new Thread(task, "jyk有返回值的线程1").start();
                // new Thread(task, "jyk有返回值的线程2").start();  ——这里为什么不生效？
            }
        }

        try {
            //获取线程的返回值，get()方法将导致主线程被阻塞，直到call()方法结束并返回为止
            System.out.println("子线程的返回值："+task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
