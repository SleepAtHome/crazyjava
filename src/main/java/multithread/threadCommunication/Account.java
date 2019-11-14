package multithread.threadCommunication;

/**
 * ClassName: Account
 * Description: 验证线程通信的Account类
 *              该账户有几个线程，取钱/存钱，不断重复，但是只能存一次取一次，不能一下存两次或者一下取两次（共用一个账户）
 * date: 2019/11/14 23:21
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class Account {
    private String accountNo;
    private double balance;
    /**
     * 标识账户中是否有存款的flag
     */
    private boolean flag = false;

    public Account() {
    }

    public Account(String accountNo, double balance) {
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


    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    // 取钱
    public synchronized void draw(double drawAmount) {
        try {
            // 如果flag==false，表示账户中没钱，取钱方法阻塞
            if (!flag) {wait();}
            else {
                // 取钱
                System.out.println(Thread.currentThread().getName()+"取钱.."+drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额为："+balance);
                flag = false;
                // 唤醒其他线程
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 存钱
    public synchronized void deposit(double depositAmount) {
        try {
            // 如果flag==true，表示账户中有钱，存钱方法阻塞
            if (flag) {wait();}
            else {
                // 存钱
                System.out.println(Thread.currentThread().getName()+"存钱.."+depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为："+balance);
                flag = true;
                // 唤醒其他线程
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
