package az.spring.controller;


import az.spring.dto.CustomerDTO;
import az.spring.services.CustomerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/login")
public class LoginController {
    private final CustomerServices customerServices;

    @PostMapping
    public ResponseEntity<?> login(HttpServletResponse response,
                                   @RequestParam String userName,
                                   @RequestParam String password) throws IOException {
        CustomerDTO customerDTO = customerServices.login(userName, password);
        if (!ObjectUtils.isEmpty(customerDTO)) {
            response.sendRedirect("api/v1/customers");
        }
        return null;
    }
}
