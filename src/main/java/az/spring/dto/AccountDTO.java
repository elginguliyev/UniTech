package az.spring.dto;

public class AccountDTO {
    private int accountId;
    private double balance;
    private double deposit;
    private double withdraw;

    public AccountDTO() {
    }

    public AccountDTO(double balance, double deposit, double withdraw) {
        this.balance = balance;
        this.deposit = deposit;
        this.withdraw = withdraw;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public int getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", deposit=" + deposit +
                ", withdraw=" + withdraw +
                '}';
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }


}

