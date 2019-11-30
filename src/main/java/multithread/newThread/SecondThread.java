package multithread.newThread;

/**
 * ClassName: SecondThread
 * Description: 实现Runnable接口创建并启动多线程
 * date: 2019/11/8 23:55
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class SecondThread implements Runnable{

    private int i;

    @Override
    public void run() {
        for ( ; i<100; i++) {
            // 这里于通过继承Thread实现的多线程不同，这里不能使用this来获得当前线程对象，只能用Thread.currentThread()来获取当前线程对象
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }

    public static void main(String[] args) {
        for (int a = 0; a<100; a++) {
            System.out.println(Thread.currentThread().getName()+"=="+a);

            if (20 == a) {
                // st为Thread的target
                //这里于通过继承Thread实现的多线程也不同，创建Thread的子类即可代表线程对象，而这里的Runnable对象只能作为线程的target
                SecondThread st = new SecondThread();

                //使用 new Thread(target, name) 方法创建新线程
                new Thread(st, "jyk线程1").start();
                new Thread(st, "jyk线程2").start();

                // 运行程序可以发现，两个线程的i是连续的，也就是说，采用Runnable接口的方式创建的多个线程可以共享线程类的实例属性。
            }
        }
    }
}
