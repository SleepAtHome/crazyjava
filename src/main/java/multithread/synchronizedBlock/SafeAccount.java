package multithread.synchronizedBlock;

/**
 * ClassName: Account
 * Description: 安全地银行账户（同步方法）
 * date: 2019/11/13 23:33
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class SafeAccount {
    /**
     * 账户号
     */
    private String accountNo;
    /**
     * 余额
     */
    private double balance;

    public SafeAccount() {
    }

    public SafeAccount(String accountNo, double balance) {
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
        return balance;
    }

    public synchronized void draw(double drawAmount) {
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
        if (obj!=null && obj.getClass()==SafeAccount.class) {
            SafeAccount target = (SafeAccount) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}
