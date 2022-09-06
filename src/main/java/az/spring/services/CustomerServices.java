package az.spring.services;

import az.spring.dto.AccountDTO;
import az.spring.dto.CustomerDTO;
import az.spring.model.Account;
import az.spring.model.Customer;
import az.spring.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServices {

    private final CustomerRepository customerRepository;

    public List<CustomerDTO> getAll() {
        List<CustomerDTO> customerDTOS= customerRepository.findAll()
                .stream()
                .map(customer -> convertToDTO(customer))
                .collect(Collectors.toList());
        return customerDTOS;
    }

    private CustomerDTO convertToDTO( Customer customer) {
        CustomerDTO customerDTO=new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        customerDTO.setAccountDTOS(customer.getAccounts()
                .stream()
                .map(account -> convertToAccDTO(account))
                .collect(Collectors.toList()));
        return customerDTO;
    }

    private AccountDTO convertToAccDTO(Account account) {
        AccountDTO accountDTO= new AccountDTO();
        BeanUtils.copyProperties(account, accountDTO);
        return  accountDTO;
    }

    public CustomerDTO getById(int id) {
        Optional<CustomerDTO> customer = customerRepository.findById(id)
                .map(customer1 -> convertToDTO(customer1));
        if (customer.isPresent()) {
           return customer.get();
        }
        return null;
    }

    public void add(CustomerDTO customerDTO) {
        Customer customer1 = addCustomer(customerDTO);
        customerRepository.save(customer1);
    }

    public void upDate(int id, CustomerDTO customerDTO) {
        Optional<Customer> customer1 = customerRepository.findById(id);
        if (customer1.isPresent()) {
            Customer customer2 = customer1.get();
            convert(customerDTO, customer2);
        }
    }

    public void delete(int id) {
        customerRepository.deleteById(id);
    }


    private void convert(CustomerDTO getCustomerDTO, Customer setCustomer) {
        setCustomer.setName(getCustomerDTO.getName());
        setCustomer.setSurname(getCustomerDTO.getSurname());
        setCustomer.setEmail(getCustomerDTO.getEmail());
        setCustomer.setAge(getCustomerDTO.getAge());
        setCustomer.setBirthDate(getCustomerDTO.getBirthDate());
        setCustomer.setUserName(getCustomerDTO.getUserName());
        setCustomer.setPassword(getCustomerDTO.getPassword());
    }

    private Customer addCustomer(CustomerDTO customerDTO) {
        Customer customer1 = new Customer();
        convert(customerDTO, customer1);
        customer1.setName(customerDTO.getName());
        return customer1;
    }
}
