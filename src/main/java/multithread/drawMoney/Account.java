package multithread.drawMoney;

/**
 * ClassName: Account
 * Description: 银行账户（验证线程安全问题）
 * date: 2019/11/13 23:33
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class Account {
    /**
     * 账户号
     */
    private String accountNo;
    /**
     * 余额
     */
    private double balance;

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
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
        if (obj!=null && obj.getClass()==Account.class) {
            Account target = (Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}
