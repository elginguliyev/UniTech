package az.spring.model;

import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    private double balance;
    private double deposit;
    private double withdraw;
//    @ManyToOne()
//    private Customer customer;
}
