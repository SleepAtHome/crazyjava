package multithread.synchronizedBlock;

import multithread.drawMoney.Account;

/**
 * ClassName: DrawThread
 * Description: 带同步代码块的取钱线程
 * date: 2019/11/14 18:22
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class DrawThread extends Thread {
    private Account account;
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        // 使用account作为同步监视器，任何线程进入同步代码块之前，必须先获得account账户的锁定——其他线程无法获得锁，也就无法修改它
        // 符合“加锁 -> 修改 -> 释放锁”的逻辑
        synchronized (account) {
            if (account.getBalance() >= drawAmount) {
                System.out.println(getName()+"==取钱成功=="+drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("\t余额为："+account.getBalance());
            } else {
                System.out.println("取钱失败！余额不足！");
            }
        }
    }
}
