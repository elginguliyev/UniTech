package az.spring.dto;

import az.spring.model.Customer;

public class AccountDTO {
    private int accountId;
    private double balance;
    private double deposit;
    private double withdraw;
    private CustomerDTO customerDTO;

    public AccountDTO() {
    }

    public AccountDTO(double balance, double deposit, double withdraw) {
        this.balance = balance;
        this.deposit = deposit;
        this.withdraw = withdraw;
    }

    public AccountDTO(int accountId, double balance, double deposit, double withdraw, CustomerDTO customerDTO) {
        this.accountId = accountId;
        this.balance = balance;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.customerDTO = customerDTO;
    }

    public  void addCustomer(CustomerDTO customerDTO){
        this.customerDTO=customerDTO;
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

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
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

