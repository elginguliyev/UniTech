package az.spring.controller;

import az.spring.dto.CustomerDTO;
import az.spring.services.CustomerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServices customerServices;

    @GetMapping(path = "/unitech")
    public ResponseEntity index() {
       return new ResponseEntity<>("salam", HttpStatus.OK);
    }

     @GetMapping(path = "/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customerDTOS = customerServices.getAll();
        return  new ResponseEntity<>(customerDTOS, HttpStatus.OK);
    }
}
