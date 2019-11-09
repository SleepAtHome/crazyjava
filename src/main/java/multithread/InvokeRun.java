package multithread;

/**
 * ClassName: InvokeRun
 * Description: 直接调用run()方法，不产生新线程
 * date: 2019/11/9 10:28
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class InvokeRun extends Thread {
    private int i;

    @Override
    public void run() {
        for ( ; i<100; i++) {
            // 这里不用this是因为，直接调用run()方法时，this.getName()返回的是该对象的名字，而不是线程名。
            // 而Thread.currentThread().getName()总是获取当前线程的名字。
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }

    public static void main(String[] args) {
        for (int a = 0 ; a<100; a++) {
            System.out.println(Thread.currentThread().getName()+"--"+a);

            if (20 == a) {

                // 直接调用线程对象的run()方法时，系统会把线程当成普通对象，把run()方法当成普通方法。所以下面不会产生多线程。
                new InvokeRun().run();
                new InvokeRun().run();
            }
        }
    }
}
