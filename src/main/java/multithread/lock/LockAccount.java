package multithread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: LockAccount
 * Description: 安全地银行账户（同步锁Lock）
 * date: 2019/11/13 23:33
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class LockAccount {

    /**
     * 定义锁对象
     */
    private final ReentrantLock lock = new ReentrantLock();
    private String accountNo;
    private double balance;

    public LockAccount() {
    }

    public LockAccount(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return this.balance;
    }

    /**
     * 需要保证线程安全的取钱方法
     * @param drawAmount
     */
    public synchronized void draw(double drawAmount) {
        // 上锁
        lock.lock();
        // try中写需要保证线程安全的代码
        try {
            if (balance >= drawAmount) {
                System.out.println(Thread.currentThread().getName()+"==取钱成功=="+drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance -= drawAmount;
                System.out.println("\t余额为："+ balance);
            } else {
                System.out.println("取钱失败！余额不足！");
            }
        // 使用finally块来保证释放锁
        }finally {
            // 修改完成，释放锁
            lock.unlock();
        }

    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj!=null && obj.getClass()==LockAccount.class) {
            LockAccount target = (LockAccount) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}
