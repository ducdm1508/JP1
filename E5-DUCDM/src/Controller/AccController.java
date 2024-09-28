package Controller;

import Entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccController {

    public static List<Account> accounts;

    public AccController(List<Account> accounts) {
        AccController.accounts = accounts;
    }

    public static List<Account> getAccountsById(String id) {
        return accounts.stream()
                .filter(account -> Integer.toString(account.getId()).equals(id))
                .toList();
    }
    public static List<Account> getAccountsByName(String name) {
        return accounts.stream()
                .filter(account -> account.getCustomerName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

}
