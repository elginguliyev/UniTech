package az.spring.security;

import az.spring.dto.CustomerDTO;
import az.spring.services.CustomerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private  final CustomerServices customerServices;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        CustomerDTO customerDTO=customerServices.getByUserName(userName);
        if (customerDTO != null){

            User.UserBuilder builder= User.withUsername(userName);

            builder.disabled(false);
            builder.password(customerDTO.getPassword());

            String[] authoritiesArr= new String[] {"ADMIN", "USER"};
            builder.authorities(authoritiesArr);

            return  builder.build();
        }else {
            throw  new UsernameNotFoundException("Customer not found");
        }
    }

}


