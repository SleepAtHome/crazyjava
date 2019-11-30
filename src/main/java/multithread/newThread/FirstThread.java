package multithread.newThread;

/**
 * ClassName: FirstThread
 * Description: 继承Thread类创建线程类
 * date: 2019/11/8 21:54
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class FirstThread extends Thread{
    private int i;

    /**
     * 重写run()方法，run()方法的方法体就是线程的执行体
     */
    @Override
    public void run() {
        for ( ; i<100; i++) {
            // 当线程继承Thread类时，直接用This即可获取当前线程。getName()方法返回当前线程名字。
            System.out.println(getName()+"--"+i);
        }
    }

    // 主线程
    public static void main(String[] args) {
        for (int a = 0; a<100; a++) {
            // 调用Thread的currentThread()方法获取当前线程
            System.out.println(Thread.currentThread().getName()+"=="+a);

            if (20 == a) {
                // 创建启动第一个线程
                new FirstThread().start();
                // 创建启动第二个线程
                new FirstThread().start();
            }
        }
    }
}
