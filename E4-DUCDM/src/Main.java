import Entity.Customer;
import Entity.Invoice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();

        customers.add(new Customer(1, "Nguyen Van A", 12));
        customers.add(new Customer(2, "Nguyen Van B", 20));
        customers.add(new Customer(3, "Nguyen Van C", 8));

        invoices.add(new Invoice(1, customers.get(0), 1000));
        invoices.add(new Invoice(2, customers.get(1), 1500));
        invoices.add(new Invoice(3, customers.get(1), 2000));
        invoices.add(new Invoice(4, customers.get(2), 500));
        invoices.add(new Invoice(5, customers.get(2), 2900));
        invoices.add(new Invoice(6, customers.get(0), 1200));

        invoices.forEach(invoice -> {
                System.out.println(invoice);
                System.out.println("id is: " + invoice.getId());
                System.out.println("customer is: " + invoice.getCustomer());
                System.out.println("amount is: " + invoice.getAmount());
                System.out.println("customer's id is: " + invoice.getCustomerId());
                System.out.println("customer's name is: " + invoice.getCustomerName());
                System.out.println("customer's discount is: " + invoice.getCustomerDiscount());
                System.out.printf("amount after discount is: %.2f%n", invoice.getAmountAfterDiscount());
            }
        );

        customers.forEach(customer -> {
            System.out.println("Hoá đơn của khách hàng có id = " + customer.getId() + ": ");
            invoices.stream()
                    .filter(invoice -> invoice.getCustomerId() == customer.getId())
                    .forEach(System.out::println);
        });

        Optional<Customer> maxAmountCus = customers.stream()
                .max(Comparator.comparingDouble(customer ->
                        invoices.stream()
                                .filter(invoice -> invoice.getCustomerId() == customer.getId())
                                .mapToDouble(Invoice::getAmount)
                                .sum()
                ));
        System.out.println("Khách hàng có tổng hóa đơn lớn nhất là: " + maxAmountCus);


        Optional<Customer> minDiscountCus = customers.stream()
                .min(Comparator.comparing(Customer::getDiscount)
                );
        System.out.println("Khách hàng có mã giảm giá thấp nhất la: " + minDiscountCus);

        System.out.println("Nhap id don hang hang hoac ten khach hang: ");
        String search = sc.nextLine();
        System.out.println("Kết quả tìm kiếm cho: " + search);
        invoices.stream()
                .filter(invoice -> invoice.getCustomerName().contains(search))
                .forEach(System.out::println);
        invoices.stream()
                .filter(invoice -> String.valueOf(invoice.getId()).equals(search))
                .forEach(System.out::println);
    }
}