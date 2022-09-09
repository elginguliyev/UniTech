package az.spring.dto;

public class TransactionDTO {

    private  int transactioId;
    private  int fromAccountNum;
    private  int toAccountNum;
    private  double amount;

    public TransactionDTO() {
    }

    public TransactionDTO(int fromAccountNum, int toAccountNum, double amount) {
        this.fromAccountNum = fromAccountNum;
        this.toAccountNum = toAccountNum;
        this.amount = amount;

    }

    public int getTransactioId() {
        return transactioId;
    }

    public void setTransactioId(int transactioId) {
        this.transactioId = transactioId;
    }

    public int getFromAccountNum() {
        return fromAccountNum;
    }

    public void setFromAccountNum(int fromAccountNum) {
        this.fromAccountNum = fromAccountNum;
    }

    public int getToAccountNum() {
        return toAccountNum;
    }

    public void setToAccountNum(int toAccountNum) {
        this.toAccountNum = toAccountNum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
