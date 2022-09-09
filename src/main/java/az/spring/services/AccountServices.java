package az.spring.services;

import az.spring.dto.AccountDTO;
import az.spring.model.Account;
import az.spring.model.Customer;
import az.spring.repository.AccountRepositoriy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public void add(AccountDTO accountDTO) {
        Account account = new Account();
        Customer customer = new Customer();
        BeanUtils.copyProperties(accountDTO.getCustomerDTO(), customer);
        account.setBalance(accountDTO.getBalance());
        account.setDeposit(accountDTO.getDeposit());
        account.setWithdraw(accountDTO.getWithdraw());
        account.setCustomer(customer);
        accountRepositoriy.save(account);
    }

    public AccountDTO getById(int id) {
        Optional<AccountDTO> accountDTO = accountRepositoriy.findById(id)
                .map(account ->converDTO(account));
        if (accountDTO.isPresent()) {
            accountDTO.get();
        }
        return null;
    }

    public  void upDate(int id , AccountDTO accountDTO){
        Optional<Account> account=accountRepositoriy.findById(id);
        if (account.isPresent()){
            Account account1=account.get();
            account1.setDeposit(accountDTO.getDeposit());
            account1.setBalance(accountDTO.getBalance());
            account1.setWithdraw(accountDTO.getWithdraw());
            accountRepositoriy.save(account1);
        }
    }

    public void delete(int id) {
        accountRepositoriy.deleteById(id);
    }


}
