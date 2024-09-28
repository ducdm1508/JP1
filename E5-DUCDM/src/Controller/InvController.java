package Controller;

import Entity.Invoice;

import java.util.List;

public class InvController {
    public static List<Invoice> invoices;

    public InvController (List<Invoice> invoices) {
        InvController.invoices = invoices;
    }
    public static List<Invoice> getInvoicesId(String id) {
        return invoices.stream()
                .filter(account -> Integer.toString(account.getId()).equals(id))
                .toList();
    }
    public static List<Invoice> getInvoiceName(String name) {
        return invoices.stream()
                .filter(account -> account.getCustomerName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
