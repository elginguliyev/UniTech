package az.spring;

import az.spring.dto.AccountDTO;
import az.spring.dto.CustomerDTO;
import az.spring.model.Customer;
import az.spring.services.AccountServices;
import az.spring.services.CustomerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class UniTechApplication {

    private final CustomerServices customerServices;
    private final AccountServices accountServices;

    public static void main(String[] args) {
        SpringApplication.run(UniTechApplication.class, args);
    }

    @Bean
    public CommandLineRunner runer() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                CustomerDTO customerDTO = new CustomerDTO("eli", "eliyev", null, 1, null, null, null);
                AccountDTO accountDTO = new AccountDTO(100, 50, 50);
                AccountDTO accountDTO11 = new AccountDTO(100, 50, 50);
//
                List<AccountDTO> accountDTOS = Arrays.asList(accountDTO, accountDTO11);
                customerDTO.setAccountDTOS(accountDTOS);
                customerServices.add(customerDTO);
//                accountServices.add(accountDTO);

//                List<CustomerDTO> customers = customerServices.getAll();
//                System.out.println(customers);

//                List<AccountDTO> accountDTO1=accountServices.getAllAccount();
//                System.out.println(accountDTO1);
//                CustomerDTO customerDTO1=customerServices.getById(3);
//                System.out.println(customerDTO1);
            }
        };

    }
}



