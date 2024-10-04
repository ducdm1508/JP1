package Entity;

import java.time.LocalDateTime;

public class Account {
    public int id;
    public String accountNumber;
    private Customer customer;
    private double balance;
    private LocalDateTime createdAt;

    public Account() {;}

    public Account(int id, String accountNumber, Customer customer, double balance, LocalDateTime createdAt) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName(){
        return customer.getName();
    }

    public String getCustomerCode(){
        return customer.getCode();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", customer=" + customer +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                '}';
    }
}
