package multithread;

/**
 * ClassName: ThreadLocalTest
 * Description: 测试ThreadLocal类(解决多线程中对同一变量的访问冲突)
 * date: 2019/11/30 19:45
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        // 这里设置的是主线程设置的账户名（ThreadLocal类变量），所以A、B线程一开始打印用户名时，因为未进行复制，所以为null。
        Account a = new Account("初始名");

        /*
        两个线程共享同一个账户-->只有一个账户名
        但是账户名是ThreadLocal类型的，所以每个线程都完全拥有各自账户名的副本-->i==6之后，可以看到两个线程访问同一账户时出现不同的账户名
         */
        new JYKTest("线程A", a).start();
        new JYKTest("线程B", a).start();
    }
}

class Account {
    /**
     * 一个ThreadLocal类型的变量，是一个线程局部变量，每个线程都会保留该变量的一个副本。
     */
    private ThreadLocal<String> name = new ThreadLocal<>();

    public Account(String name) {
        // 给ThreadLocal类对象set()
        this.name.set(name);
        // 从ThreadLocal类get()
        System.out.println(this.name.get());
    }

    public String getName() { return name.get(); }
    public void setName(String str) { this.name.set(str); }
}

class JYKTest extends Thread {
    private Account account;

    public JYKTest(String name, Account account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            // 当i==6 时，将账户名替换成当前线程名。
            if (i==6) {
                account.setName(Thread.currentThread().getName());
            }
            System.out.println(account.getName()+" 账户的i值："+i);
        }
    }
}
