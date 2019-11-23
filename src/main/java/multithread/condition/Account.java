package multithread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: Account
 * Description: Account账户，多线程（使用Condition控制线程通信）
 * date: 2019/11/23 11:38
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class Account {
    /**
     * 显示定义Lock对象
     */
    private final Lock lock = new ReentrantLock();
    /**
     * 获得指定Lock对象对应的Condition
     */
    private final Condition condition = lock.newCondition();
    private String accountNo;
    private double balance;
    /**
     * 标识账户中是否有存款的flag
     */
    private boolean flag = false;

    public Account() { }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public Lock getLock() {
        return lock;
    }

    public Condition getCondition() {
        return condition;
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



    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void draw(double drawAmount) {
        // 上锁
        lock.lock();
        try {
            // 如果账户没钱，等待，等待存钱
            if (!flag) {
                condition.await();
            } else {
                // 如果账户有钱，则进行取钱
                System.out.println(Thread.currentThread().getName()+"取钱："+drawAmount);
                balance -= drawAmount;
                System.out.println("余额为："+balance);
                flag = false;
                // 唤醒其他线程
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 使用finally块来释放锁
            lock.unlock();
        }
    }

}
