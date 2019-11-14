package multithread.threadCommunication;

/**
 * ClassName: DrawTest
 * Description: 线程通信的存取款操作
 *              这里最终程序被阻塞，因为取钱只取100次，存钱会存300次，所以最后一次取钱以后程序阻塞（不是死锁）。
 * date: 2019/11/14 23:40
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class DrawTest {
    public static void main(String[] args) {
        Account account = new Account("1234567", 0);
        new DrawThread("取钱者", account, 800).start();
        // 有3个人抢着存钱
        new DepositThread("存钱者A", account, 800).start();
        new DepositThread("存钱者B", account, 800).start();
        new DepositThread("存钱者C", account, 800).start();
    }
}
