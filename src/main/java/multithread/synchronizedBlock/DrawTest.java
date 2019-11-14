package multithread.synchronizedBlock;

import multithread.drawMoney.Account;

/**
 * ClassName: DrawTest
 * Description: 测试取钱行为（带同步代码块的）
 * date: 2019/11/14 0:31
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class DrawTest {
    public static void main(String[] args) {
        // 创建一个账户
        Account account = new Account("773669388",1000);

        // 两个线程对同一个账户取钱(带同步代码块)
        new DrawThread("A",account,800).start();
        new DrawThread("B",account,800).start();
    }
}
