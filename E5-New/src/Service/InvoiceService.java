package Service;

import Entity.Account;
import Entity.Gender;
import Entity.Invoice;
import Global.Global;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class InvoiceService {

    private List<Invoice> invoices;
    public InvoiceService(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Invoice getInvoiceId(int id) {
        Optional<Invoice> findInv =
                invoices.stream()
                        .filter(i -> i.getId() == id)
                        .findFirst();
        if (findInv.isPresent()) {
            return findInv.get();

        }else {
            return null;
        }
    }

    public List<Invoice> getInvoiceByName(String name) {

        List<Invoice> findInv = invoices.stream()
                .filter(inv -> Global.ignoreCase(inv.getCusName(), name))
                .toList();

        if (findInv.size() >0 ) {
            return findInv;
        }else {
            return null;
        }
    }

    public List<Invoice> applyDiscountForFemaleAugustInvoices() {
        List<Invoice> discountedInvoices = invoices.stream()
                .filter(inv -> inv.getCustomer().getGender() == Gender.F)
                .filter(inv -> inv.getDatetime().getMonthValue() == 8)
                .toList();

        discountedInvoices.forEach(inv -> {
            double discount = inv.getCustomer().getDiscount() + 10;
            inv.setAmount(inv.getAmount() * (1 - discount / 100));
        });
        if (discountedInvoices.size() > 0) {
            return discountedInvoices;
        } else {
            return null;
        }
    }

    public List<Invoice> getCusCanNotPay(List<Account> accounts) {
        List<Invoice> cusCanNotPay = new ArrayList<>();

        accounts.forEach(account -> {
            List<Invoice> unpayableInvoices = invoices.stream()
                    .filter(inv -> inv.getCustomer().equals(account.getCustomer()))
                    .filter(invoice -> account.getBlance() < invoice.getAmountAfterDiscount())
                    .toList();
            cusCanNotPay.addAll(unpayableInvoices);
        });

        if (cusCanNotPay.size() > 0) {
            return cusCanNotPay;
        } else {
            return null;
        }
    }

    public List<Invoice> getCusCanPay(List<Account> accounts) {
        List<Invoice> cusCanNotPay = new ArrayList<>();

        accounts.forEach(account -> {
            List<Invoice> unpayableInvoices = invoices.stream()
                    .filter(inv -> inv.getCustomer().equals(account.getCustomer()))
                    .filter(invoice -> account.getBlance() >= invoice.getAmountAfterDiscount())
                    .toList();
            cusCanNotPay.addAll(unpayableInvoices);
        });

        if (cusCanNotPay.size() > 0) {
            return cusCanNotPay;
        }else {
            return null;
        }
    }
}
