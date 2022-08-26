package az.spring.repository;

import az.spring.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

       List<Customer> getByNameAndSurname(String name , String surname);

       Customer getByUserName(String name);
}
