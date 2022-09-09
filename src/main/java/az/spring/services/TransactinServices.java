package az.spring.services;

import az.spring.dto.AccountDTO;
import az.spring.dto.TransactionDTO;
import az.spring.repository.AccountRepositoriy;
import az.spring.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactinServices {


    private final TransactionRepository transactionRepository;
    private final AccountServices accountServices;

    public TransactionDTO sendMany(int fromAccountNum, int toAccountNum, double amount) {
        AccountDTO fromAccount = accountServices.getById(fromAccountNum);
        AccountDTO toAccount = accountServices.getById(toAccountNum);
        if (fromAccount.getBalance() > amount) {
            double balance = toAccount.getBalance() + amount;
            double fromBalance= fromAccount.getBalance()-amount;
        }
        return null;
    }


}
