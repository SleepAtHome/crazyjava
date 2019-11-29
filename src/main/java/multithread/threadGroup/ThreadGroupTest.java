package multithread.threadGroup;

/**
 * ClassName: ThreadGroupTest
 * Description: 线程组
 * date: 2019/11/29 23:47
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        // 得到主线程所属的线程组，是所有线程的默认线程组
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程名字："+mainGroup.getName());
        System.out.println("主线程组是否是后台线程组：" +mainGroup.isDaemon());

        new JYKThread("主线程的线程").start();
        ThreadGroup threadGroup = new ThreadGroup("新线程组");
        threadGroup.setDaemon(true);
        System.out.println("新线程组是否是后台线程组：" +threadGroup.isDaemon());

        JYKThread jyk = new JYKThread(threadGroup, "threadGroup的线程甲");
        jyk.start();
        new JYKThread(threadGroup, "threadGroup的线程乙").start();
    }
}

class JYKThread extends Thread {
    public JYKThread(String name) {
        super(name);
    }

    public JYKThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        for (int i=0; i<20; i++) {
            System.out.println(getName()+"线程的i变量：" + i);
        }
    }
}
