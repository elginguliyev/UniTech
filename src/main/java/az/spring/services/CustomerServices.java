package az.spring.services;

import az.spring.model.Customer;
import az.spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customer.get();
        }
        return null;
    }

    public void add(Customer customer) {
        Customer customer1 = addCustomer(customer);
        customerRepository.save(customer1);
    }

    public void upDate(int id, Customer customer) {
        Optional<Customer> customer1 = customerRepository.findById(id);
        if (customer1.isPresent()) {
            Customer customer2 = customer1.get();
            convert(customer, customer2);
        }
    }

    public void delete(int id) {
        customerRepository.deleteById(id);
    }


    private void convert(Customer getCustomer, Customer setCustomer) {
        setCustomer.setName(getCustomer.getName());
        setCustomer.setSurname(getCustomer.getSurname());
        setCustomer.setEmail(getCustomer.getEmail());
        setCustomer.setAge(getCustomer.getAge());
        setCustomer.setBirthDate(getCustomer.getBirthDate());
        setCustomer.setUserName(getCustomer.getUserName());
        setCustomer.setPassword(getCustomer.getPassword());
    }

    private Customer addCustomer(Customer customer) {
        Customer customer1 = new Customer();
        convert(customer, customer1);
        return customer1;
    }
}
