package multithread;

/**
 * ClassName: StartDead
 * Description: 线程死亡后再次调用start()方法
 * date: 2019/11/9 11:03
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class StartDead extends Thread{
    private int i;

    @Override
    public void run() {
        for ( ; i<100; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }

    public static void main(String[] args) {
        StartDead sd = new StartDead();
        for (int a = 0 ; a<300; a++) {
            System.out.println(Thread.currentThread().getName()+"--"+a);

            if (20 == a) {
                sd.start();
                System.out.println(sd.isAlive());
            }

            // 线程死亡后
            if (a > 20 && !sd.isAlive()) {
                // 尝试对已死亡的线程调用start()
                sd.start();
            }
        }
    }
}
