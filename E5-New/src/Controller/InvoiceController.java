package Controller;

import Entity.Account;
import Entity.Invoice;
import Service.InvoiceService;

import java.util.ArrayList;
import java.util.List;

public class InvoiceController {

    private List<Invoice> invoices;
    private Invoice invoice;
    private InvoiceService is;

    public InvoiceController(InvoiceService is) {
        this.is = is;
    }

    public Invoice getInvoiceById(int id) {
        Invoice found = is.getInvoiceId(id);
        if (found == null) {
            return null;
        }else {
            return found;
        }
    }

    public List<Invoice> getInvoicesByName(String name) {
        List<Invoice> found = is.getInvoiceByName(name);
        if (found == null) {
            return null;
        }else {
            return found;
        }
    }
    public List<Invoice> applyDiscountForFemaleAugustInvoices(){
        List<Invoice> discouted = is.applyDiscountForFemaleAugustInvoices();
        return discouted;
    }

}
