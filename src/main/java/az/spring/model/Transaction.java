package az.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int transferId;
    private int fromAccountNum;
    private int toAccountNum;
    private double amount;

    public Transaction(int fromAccountNum, int toAccountNum, double amount) {
        this.fromAccountNum = fromAccountNum;
        this.toAccountNum = toAccountNum;
        this.amount = amount;
    }
}
