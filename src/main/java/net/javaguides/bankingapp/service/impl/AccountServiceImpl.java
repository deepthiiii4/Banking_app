package net.javaguides.bankingapp.service.impl;

import net.javaguides.bankingapp.dto.AccountDto;
import net.javaguides.bankingapp.entity.Account;
import net.javaguides.bankingapp.mapper.AccountMapper;
import net.javaguides.bankingapp.repository.AccountRepository;
import net.javaguides.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapTOAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account  = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }


    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account =  accountRepository.findById(id).orElseThrow(() -> new RuntimeException("account does not exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account =  accountRepository.findById(id).orElseThrow(() -> new RuntimeException("account does not exist"));
        if(account.getBalance() < amount)
        {
            throw new RuntimeException("insufficient balance");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount= accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<Object> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(account -> AccountMapper.mapTOAccountDto(account))
                .collect(Collectors.toList());
    }
    ;

    }

    @Override
    public void deleteAccount(Long id) {
        Account account =  accountRepository.findById(id).orElseThrow(() -> new RuntimeException("account does not exist"));
        accountRepository.deleteById(id);

    }


}
