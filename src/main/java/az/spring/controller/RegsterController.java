package az.spring.controller;

import az.spring.dto.CustomerDTO;
import az.spring.services.CustomerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regster")
@RequiredArgsConstructor
public class RegsterController {

    private final CustomerServices customerServices;

    @PostMapping
    public ResponseEntity<?> regster(@RequestBody CustomerDTO customerDTO) {
        customerServices.add(customerDTO);
        return new ResponseEntity<>("regster succesfull", HttpStatus.OK);
    }
}
