package az.spring;

import az.spring.dto.AccountDTO;
import az.spring.dto.CustomerDTO;
import az.spring.model.Account;
import az.spring.model.Customer;
import az.spring.repository.AccountRepositoriy;
import az.spring.services.AccountServices;
import az.spring.services.CustomerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class UniTechApplication {

    private final CustomerServices customerServices;
    private final AccountServices accountServices;
    private final AccountRepositoriy accountRepositoriy;

    public static void main(String[] args) {
        SpringApplication.run(UniTechApplication.class, args);
    }

    @Bean
    public CommandLineRunner runer() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                Customer customer = new Customer("ad", "soyad", "null", 12, new Date(), null, null);
//                Account account = new Account(0, 50, 30, 60, customer);
//                accountRepositoriy.save(account);


                CustomerDTO customerDTO = new CustomerDTO("eli1", "eliyev2", null, 12, new Date(), null, null);
                CustomerDTO customerDTO1 = new CustomerDTO("eli", "eliyev", null, 1, null, null, null);

                AccountDTO accountDTO = new AccountDTO(0, 1200, 3000, 50, customerDTO);
//                AccountDTO accountDTO1 = new AccountDTO(2100, 4000, 60);
//

                System.out.println(customerServices.getByUserName("qulu_bedelov"));
            }
        };

    }
}



