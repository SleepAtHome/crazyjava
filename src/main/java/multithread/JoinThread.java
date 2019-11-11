package multithread;

/**
 * ClassName: JoinThread
 * Description: join线程
 * date: 2019/11/9 13:59
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class JoinThread extends Thread{
    /**
     * 有参构造器，用于设置该线程的名字
     * @param name
     */
    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new JoinThread("jyk新线程").start();
        for (int a=0; a<100; a++) {
            if (20 == a) {
                JoinThread jt = new JoinThread("被join的线程");
                jt.start();
                // jt线程join到main线程中
                jt.join();
            }
            System.out.println(Thread.currentThread().getName()+"=="+a);
        }
    }
}
