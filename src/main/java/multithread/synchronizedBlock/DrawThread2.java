package multithread.synchronizedBlock;

import multithread.drawMoney.Account;

/**
 * ClassName: DrawThread2
 * Description: 测试SafeAccount类（同步方法）
 * date: 2019/11/14 18:22
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class DrawThread2 extends Thread {
    private SafeAccount account;
    private double drawAmount;

    public DrawThread2(String name, SafeAccount account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        // 调用的是同步方法
        account.draw(drawAmount);
    }
}
