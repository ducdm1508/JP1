package Controller;

import Entity.Account;
import Service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountController {

    private AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public Optional<Account> getAccountByCustomerCode(String code) {
        return accountService.getAccountByCustomerCode(code);
    }

    public List<Account> getAccountByCustomerName(String name) {
        return accountService.getAccountsByCustomerName(name);
    }


    public Optional<Account> getAccountByCustomer(){
        return accountService.getAccountByCustomer();
    }

    public Optional<Account> countAccountByCustomer(){
        return accountService.getAccountByCustomer();
    }

    public Optional<Account> getMaxBalance() {
        return accountService.getMaxBalance();
    }
}
