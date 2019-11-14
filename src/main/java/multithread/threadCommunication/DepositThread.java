package multithread.threadCommunication;

/**
 * ClassName: DrawThread
 * Description: 验证线程通信的存钱线程
 * date: 2019/11/14 23:34
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class DepositThread extends Thread {
    private Account account;
    /**
     * 要存的钱数
     */
    private double depositAmount;

    public DepositThread(String name, Account account, double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        // 重复100次存钱操作
        for (int i=0; i<100; i++) { account.deposit(depositAmount);}
    }
}
