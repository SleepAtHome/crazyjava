package multithread;

/**
 * ClassName: PriorityTest
 * Description: 线程优先级
 * date: 2019/11/11 23:16
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class PriorityTest extends Thread {
    public PriorityTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=0 ; i<50; i++) {
            System.out.println(getName()+"--优先级："+getPriority()+"|||"+i);
        }
    }

    public static void main(String[] args) {
        // 设置当前线程优先级
        Thread.currentThread().setPriority(6);

        for (int a = 0; a<30; a++) {
            if (a == 10) {
                PriorityTest low = new PriorityTest("low线程");
                low.start();
                System.out.println("低优先级线程创建"+low.getPriority());
                low.setPriority(Thread.MIN_PRIORITY);
            }
            if (a == 20) {
                PriorityTest high = new PriorityTest("high线程");
                high.start();
                System.out.println("高优先级线程创建"+high.getPriority());
                high.setPriority(Thread.MAX_PRIORITY);
            }
            System.out.println(Thread.currentThread().getName()+"=="+a);
        }
    }
}
