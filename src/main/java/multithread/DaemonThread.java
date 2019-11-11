package multithread;

/**
 * ClassName: DaemonThread
 * Description: 后台线程（守护线程）
 * date: 2019/11/11 22:43
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class DaemonThread extends Thread{
    @Override
    public void run() {
        for (int i=0 ; i<1000; i++) {
            System.out.println(getName()+"--"+i);
        }
    }

    public static void main(String[] args) {
        DaemonThread dt = new DaemonThread();

        // 设置为守护线程，要在该线程启动前进行设置。
        dt.setDaemon(true);
        //启动后台线程
        dt.start();
        for (int a = 0; a<100; a++) {
            System.out.println(Thread.currentThread().getName()+"=="+a);
        }

        // main结束
        // 后台线程结束（i到不了1000）

    }
}
