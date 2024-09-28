package Controller;

import Entity.Customer;

import java.util.Comparator;
import java.util.List;

public class CustomerController {

    private static List<Customer> customers;

    public CustomerController(List<Customer> customers) {
        CustomerController.customers = customers;
    }

    public static List<Customer> sortCustomersByName(List<Customer> customers) {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .toList();
    }
}
