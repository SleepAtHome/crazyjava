package multithread.drawMoney;

/**
 * ClassName: DrawTest
 * Description: 测试取钱行为
 * date: 2019/11/14 0:31
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class DrawTest {
    public static void main(String[] args) {
        // 创建一个账户
        Account account = new Account("773669388",1000);

        // 两个线程对同一个账户取钱(因为设置了线程休眠，所以总会出现两笔取钱都成功，而余额为-600的情况)
        new DrawThread("A",account,800).start();
        new DrawThread("B",account,800).start();
    }
}
