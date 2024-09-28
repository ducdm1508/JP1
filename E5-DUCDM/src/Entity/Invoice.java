
package Entity;

import java.time.LocalDate;

public class Invoice {
    private int id;
    private Customer customer;
    private double amount;
    private LocalDate datetime;

    public Invoice(int id, Customer customer, double amount, LocalDate datetime) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
        this.datetime =datetime;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }

    public int getCustomerDiscount() {
        return customer.getDiscount();
    }

    public double getAmountAfterDiscount() {
        return amount * (1 - (double) customer.getDiscount() / 100);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", name = " + customer.getName() +
                ", amount=" + amount +
                ", datetime=" + datetime +
                '}';
    }
}
