package multithread.condition;

/**
 * ClassName: DrawThread
 * Description: 验证线程通信的取钱线程（Condition）
 * date: 2019/11/14 23:34
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class DrawThread extends Thread {
    private Account account;
    /**
     * 要取的钱数
     */
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        // 重复1000次取钱操作
        for (int i=0; i<1000; i++) { account.draw(drawAmount);}
    }
}
