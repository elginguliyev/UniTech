package az.spring.services;

import az.spring.dto.AccountDTO;
import az.spring.model.Account;
import az.spring.model.Customer;
import az.spring.repository.AccountRepositoriy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServices {

    private final AccountRepositoriy accountRepositoriy;


    public List<AccountDTO> getAllAccount() {
        List<AccountDTO> accountDTOS = accountRepositoriy.findAll()
                .stream()
                .map(account -> converDTO(account))
                .collect(Collectors.toList());
        return accountDTOS;
    }

    private AccountDTO converDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        BeanUtils.copyProperties(account, accountDTO);
        return accountDTO;
    }
      public void  add(AccountDTO accountDTO){
        Account account=new Account();
        BeanUtils.copyProperties(accountDTO, account);
        accountRepositoriy.save(account);
      }

}
