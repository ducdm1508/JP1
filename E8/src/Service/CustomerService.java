package Service;

import Entity.Customer;
import Global.Global;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private final List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }

    public Optional<Customer> getById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    public Optional<Customer> getByCode(String code) {
        return customers.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();
    }

    public List<Customer> getByName(String name) {
        return customers.stream()
                .filter(c -> Global.ignoreCase(c.getName(), name))
                .toList();
    }
}
