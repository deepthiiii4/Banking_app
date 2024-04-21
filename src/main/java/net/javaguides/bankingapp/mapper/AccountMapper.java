package net.javaguides.bankingapp.mapper;

import net.javaguides.bankingapp.dto.AccountDto;
import net.javaguides.bankingapp.entity.Account;

public class AccountMapper   {
    public static Account mapTOAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account)
    {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountholderName(),
                account.getBalance()
        );
        return accountDto;
    }


    public static Object mapTOAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountholderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
