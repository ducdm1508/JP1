import Controller.AccountController;
import Controller.CustomerController;
import Controller.StaffController;
import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Staff;
import Service.AccountService;
import Service.CustomerService;
import Service.StaffService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<Customer> ();
        List<Staff> staffs = new ArrayList<Staff>();
        List<Account> accounts = new ArrayList<Account>();

        CustomerService cs = new CustomerService(customers);
        CustomerController ct = new CustomerController(cs);

        StaffService staffService = new StaffService(staffs);
        StaffController staffController = new StaffController(staffService);

        AccountService accountService = new AccountService(accounts);
        AccountController accountController = new AccountController(accountService);

        customers.add(new Customer(1, "VC001", "Lan", Gender.F));
        customers.add(new Customer(2, "VC002", "Long", Gender.M));
        customers.add(new Customer(3, "VC003", "Linh", Gender.F));
        customers.add(new Customer(4, "VC004", "Tuan", Gender.M));
        customers.add(new Customer(5, "VC005", "Nga", Gender.F));
        customers.add(new Customer(6, "VC006", "Duc", Gender.M));
        customers.add(new Customer(7, "VC007", "Hoa", Gender.F));
        customers.add(new Customer(8, "VC008", "Minh", Gender.M));

        Optional<Customer> cus = ct.getById(3);
        if (cus.isPresent()) {
            System.out.println(cus.get());
        } else {
            System.out.println("Customer not found");
        }

        staffs.add(new Staff(1, "ST001", "Vinh", LocalDateTime.of(2024,7, 27, 10 ,20)));
        staffs.add(new Staff(1, "ST001", "Linh", LocalDateTime.of(2024,4, 17, 4 , 4)));
        staffs.add(new Staff(1, "ST001", "Hung", LocalDateTime.of(2024,3, 20, 8 ,30)));
        staffs.add(new Staff(1, "ST001", "Van", LocalDateTime.of(2024,10, 11, 7 ,20)));

        Optional<Staff> staff = staffController.getStaffById(5);
        if (staff.isPresent()) {
            System.out.println(staff.get());
        }else {
            System.out.println("Staff not found");
        }

        accounts.add(new Account(1, "AC001", customers.get(1), 200000, LocalDateTime.now()));
        accounts.add(new Account(2, "AC002", customers.get(2), 2540000, LocalDateTime.now()));
        accounts.add(new Account(3, "AC003", customers.get(3), 2003400, LocalDateTime.now()));
        accounts.add(new Account(4, "AC004", customers.get(4), 200000, LocalDateTime.now()));
        accounts.add(new Account(5, "AC005", customers.get(5), 2004000, LocalDateTime.now()));
        accounts.add(new Account(6, "AC006", customers.get(6), 2000, LocalDateTime.now()));
        accounts.add(new Account(7, "AC007", customers.get(7), 20000, LocalDateTime.now()));

        Optional<Account> acc = accountService.getAccountByCustomerCode("VC002");
        accountController.getAccountByCustomerName("Vinh").forEach(System.out::println);

        if (acc.isPresent()) {
            System.out.println(acc.get());
        }else {
            System.out.println("Account not found");
        }

        Optional<Account> accountByCustomer = accountService.getAccountByCustomer();
        System.out.println(accountByCustomer.get());

        long accountCount = accountService.countAccountByCustomer();
        System.out.println("Total number of female customers with balance > 100,000 USD:  " +accountCount);

        Optional<Account> accountByMaxBalance = accountService.getMaxBalance();
        System.out.println(accountByMaxBalance.get());

    }
}