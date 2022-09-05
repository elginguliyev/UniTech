package az.spring.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Entity
@Table(name = "customer")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private int age;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String userName;
    private String password;

    @OneToMany
    @JoinTable(name = "customer_account",
            joinColumns = @JoinColumn(name = "customer_Id"),
            inverseJoinColumns = @JoinColumn(name = "account__Id"))
    private List<Account> accounts;

    public Customer(String name, String surname, String email, int age, Date birthDate, String userName, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.birthDate = birthDate;
        this.userName = userName;
        this.password = password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
