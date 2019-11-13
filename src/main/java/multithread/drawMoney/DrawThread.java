package multithread.drawMoney;

/**
 * ClassName: DrawThread
 * Description: 取钱线程类
 * date: 2019/11/13 23:39
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class DrawThread extends Thread {
    /**
     * 用户账户
     */
    private Account account;
    /**
     * 当前取钱线程所希望的钱数
     */
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    /**
     * 当多个线程修改同一个共享数据时，将涉及数据安全问题
     */
    @Override
    public void run() {
        // 有余额（可能两个线程同时进来）
        if (account.getBalance() >= drawAmount) {
            // 吐出钞票
            System.out.println(getName()+"==取钱成功=="+drawAmount);
            try {
                // 使线程休眠1ms，让另一个取钱的进程也进来
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 修改余额
            account.setBalance(account.getBalance() - drawAmount);
            System.out.println("\t余额为："+account.getBalance());
        } else {
            System.out.println("取钱失败！余额不足！");
        }
    }
}
