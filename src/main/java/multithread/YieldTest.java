package multithread;

/**
 * ClassName: YieldTest
 * Description: 线程让步yield()方法
 * date: 2019/11/11 22:58
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class YieldTest extends Thread{
    public YieldTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=0 ; i<1000; i++) {
            System.out.println(getName()+"--"+i);

            // 当i==20时，当先线程进行让步
            if (i == 20) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        // 启动两个并发线程
        YieldTest y1 = new YieldTest("高优先级线程");
        // y1.setPriority(Thread.MAX_PRIORITY);
        y1.start();
        YieldTest y2 = new YieldTest("低优先级线程");
        // y2.setPriority(Thread.MIN_PRIORITY);
        y2.start();
    }
}
