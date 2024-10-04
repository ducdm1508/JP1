package Controller;

import Entity.Invoice;

import java.util.List;
import java.util.Optional;

public class InvController {
    public static List<Invoice> invoices;

    public InvController (List<Invoice> invoices) {
        InvController.invoices = invoices;
    }
    public Optional<Invoice> getInvoicesId(String id) {
        Optional <Invoice> getInvId = invoices.stream()
                .filter(account -> Integer.toString(account.getId()).equals(id))
                .findFirst();
        return getInvId;
    }
    public static List<Invoice> getInvoiceName(String name) {
        return invoices.stream()
                .filter(account -> account.getCustomerName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
