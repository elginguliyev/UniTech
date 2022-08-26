package az.spring;

import az.spring.model.Customer;
import az.spring.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UniTechApplication {

    private final CustomerServices customerServices;

    @Autowired
    public UniTechApplication(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    public static void main(String[] args) {
        SpringApplication.run(UniTechApplication.class, args);
    }

    @Bean
    public CommandLineRunner runer() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                Customer customer = new Customer("elgin", "quliyev", null, 1, null, null, null);
                customerServices.add(customer);

                List<Customer> customers = customerServices.getAll();
                System.out.println(customers);
            }
        };

    }
}



