package multithread.condition;


/**
 * ClassName: DrawTest
 * Description: 线程通信的存取款操作（Condition）
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
        new DepositThread("存钱者C", account, 800).start();
        new DepositThread("存钱者A", account, 800).start();
        new DepositThread("存钱者B", account, 800).start();

    }
}
