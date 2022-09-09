package az.spring.dto;


import java.util.Date;
import java.util.List;

public class CustomerDTO {
    private int id;
    private String name;
    private String surname;
    private String email;
    private int age;
    private Date birthDate;
    private String userName;
    private String password;
    private List<AccountDTO> accountDTOS;


    public CustomerDTO() {
    }

    public CustomerDTO(String name, String surname, String email, int age, Date birthDate, String userName, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.birthDate = birthDate;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<AccountDTO> getAccountDTOS() {
        return accountDTOS;
    }

    public void setAccountDTOS(List<AccountDTO> accountDTOS) {
        this.accountDTOS = accountDTOS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", accountDTOS=" + accountDTOS +
                '}';
    }
}
