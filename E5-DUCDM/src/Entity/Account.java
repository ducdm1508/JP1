package Entity;

public class Account extends Customer{
    private int id;
    private Customer customer;
    private double balance;

    public Account() {;}
    public Account(int id, Customer customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        }else {
            System.out.println("amount withdrawn exceeds the cuurent balancel!");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name=" + customer.getName() +
                ", balance=" + balance +
                '}';
    }
}