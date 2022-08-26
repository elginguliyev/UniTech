package az.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private String email;
    private int age;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String userName;
    private String password;

    public Customer(String name, String surname, String email, int age, Date birthDate, String userName, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.birthDate = birthDate;
        this.userName = userName;
        this.password = password;
    }
}
