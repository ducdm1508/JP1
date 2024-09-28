import Controller.AccController;
import Controller.CustomerController;
import Controller.InvController;
import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Invoice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<Customer>();
        List<Account> accounts = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();
        AccController accController = new AccController(accounts);
        InvController invController = new InvController(invoices);
        Scanner scanner = new Scanner(System.in);



        customers.add(new Customer(1, "Trung", Gender.M, 10));
        customers.add(new Customer(2, "Linh", Gender.F, 21));
        customers.add(new Customer(3, "Hai", Gender.F, 13));
        customers.add(new Customer(4, "Hung", Gender.M, 12));


        accounts.add(new Account(1, customers.get(0), 2000));
        accounts.add(new Account(2, customers.get(1), 3000));
        accounts.add(new Account(3, customers.get(2), 4300));
        accounts.add(new Account(4, customers.get(3), 6200));


        invoices.add(new Invoice(1, customers.get(0), 4000, LocalDate.of(2024, 7, 12)));
        invoices.add(new Invoice(2, customers.get(1), 2000, LocalDate.of(2024, 1, 15)));
        invoices.add(new Invoice(3, customers.get(2), 3000, LocalDate.of(2024, 9, 10)));
        invoices.add(new Invoice(4, customers.get(3), 4500, LocalDate.of(2024, 9, 12)));

        System.out.println("1. là list");
        System.out.println("2. là sort");
        System.out.println("3. là thanh toán");
        System.out.println("4. là giảm giá");
        System.out.println("5. là search");
        System.out.printf("Choice: ");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                customers.forEach(System.out::println);
                accounts.forEach(System.out::println);
                invoices.forEach(System.out::println);
                break;
            case 2:
                CustomerController.sortCustomersByName(customers).forEach(System.out::println);
                break;
            case 3:
                System.out.println("Khách hàng có số dư đủ thanh toán:");
                accounts.forEach(account ->
                        invoices.stream()
                                .filter(invoice -> invoice.getCustomer().equals(account.getCustomer()))
                                .filter(invoice -> account.getBalance() >= invoice.getAmountAfterDiscount())
                                .forEach(invoice -> System.out.println(", Account: " + account)));

                System.out.println("\nKhách hàng không đủ số dư thanh toán:");
                accounts.forEach(account ->
                        invoices.stream()
                                .filter(invoice -> invoice.getCustomer().equals(account.getCustomer()))
                                .filter(invoice -> account.getBalance() < invoice.getAmount())
                                .forEach(invoice -> System.out.println(", Account: " + account)));
                break;
            case 4:
                invoices.stream()
                        .filter(invoice -> invoice.getDatetime().isBefore(LocalDate.now().minusMonths(8)))
                        .filter(invoice -> invoice.getCustomer().getGender() == Gender.F)
                        .forEach(invoice ->{
                            double discount = invoice.getCustomer().getDiscount() + 10;
                            invoice.setAmount(invoice.getAmount() - discount);
                            System.out.println(invoice);
                        });
                break;
            case 5:
                System.out.print("Nhập id hoặc tên để tìm kiếm: ");
                scanner.nextLine();
                String searchKey = scanner.nextLine();
                AccController.getAccountsById(searchKey).forEach(System.out::println);
                AccController.getAccountsByName(searchKey).forEach(System.out::println);

                InvController.getInvoicesId(searchKey).forEach(System.out::println);
                InvController.getInvoiceName(searchKey).forEach(System.out::println);
                break;
                default:
                    break;
        }
    }
}