package Controller;

import Entity.Customer;
import Service.CustomerService;

import java.util.List;
import java.util.Optional;

public class CustomerController {
    private final CustomerService cs;

    public CustomerController(CustomerService cs) {
        this.cs = cs;
    }

    public Optional<Customer> getById(int id) {
        return cs.getById(id);
    }

    public Optional<Customer> getByCode(String code) {
        return cs.getByCode(code);
    }

    public List<Customer> getByName(String name) {
        return cs.getByName(name);
    }
}
