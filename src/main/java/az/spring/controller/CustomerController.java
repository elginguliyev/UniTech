package az.spring.controller;

import az.spring.dto.CustomerDTO;
import az.spring.services.CustomerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServices customerServices;

    @GetMapping(path = "/unitech")
    public ResponseEntity homePage() {
        return new ResponseEntity<>("salam", HttpStatus.OK);
    }

    @GetMapping(path = "/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customerDTOS = customerServices.getAll();
        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);
    }

    @PostMapping("/add")
    public void add(@RequestBody CustomerDTO customerDTO) {
        customerServices.add(customerDTO);
    }

    @GetMapping("/id={id}")
    public CustomerDTO getById(@PathVariable int id) {
        return customerServices.getById(id);
    }

    @PutMapping("/{id}/update")
    public void upDate(@PathVariable int id, @RequestBody CustomerDTO customerDTO) {
        customerServices.upDate(id, customerDTO);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable int id) {
        customerServices.delete(id);
    }

    @GetMapping
    public CustomerDTO getByUserName(@RequestParam String userName) {
        return customerServices.getByUserName(userName);
    }


    @GetMapping("/search")
    public List<CustomerDTO> getByNameAndSurnmae(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname) {
        return customerServices.getByNameAndSurname(name, surname);
    }


}

