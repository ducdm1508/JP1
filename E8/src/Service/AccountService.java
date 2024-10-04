package Service;

import Entity.Account;
import Entity.Gender;
import Global.Global;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AccountService {

    private final List<Account> accounts;

    public AccountService(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Optional<Account> getAccountByCustomerCode (String customerCode) {
        return accounts.stream()
                .filter(acc -> acc.getCustomerCode().equalsIgnoreCase(customerCode))
                .findFirst();
    }

    public List<Account> getAccountsByCustomerName (String keyword) {
        return accounts.stream()
                .filter(acc-> Global.ignoreCase(acc.getCustomerName(), keyword))
                .toList();
    }

    public Optional<Account> getAccountByCustomer() {
        return accounts.stream()
                .filter(acc -> acc.getCustomer().getGender() == Gender.M && acc.getBalance() > 1000000)
                .findFirst();
    }

    public long countAccountByCustomer() {
        return accounts.stream()
                .filter(acc -> acc.getCustomer().getGender() == Gender.F && acc.getBalance() > 100_000)
                .count();
    }

    public Optional<Account> getMaxBalance() {
        return accounts.stream()
                .filter(acc -> acc.getCustomer().getGender() == Gender.F)
                .max(Comparator.comparingDouble(acc -> acc.getBalance()));
    }
}
