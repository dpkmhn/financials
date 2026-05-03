package com.acme.accounting.config;

import com.acme.accounting.bill.BillRequest;
import com.acme.accounting.bill.BillService;
import com.acme.accounting.customer.CustomerRequest;
import com.acme.accounting.customer.CustomerService;
import com.acme.accounting.entity.InvoiceStatus;
import com.acme.accounting.invoice.InvoiceRequest;
import com.acme.accounting.invoice.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class SeedDataConfig {
    private static final int CUSTOMER_COUNT = 500;
    private static final int BILLS_PER_CUSTOMER = 10;

    @Bean
    CommandLineRunner seed(CustomerService customers, InvoiceService invoices, BillService bills) {
        return args -> {
            String orgId = "demo-org";
            if (!customers.list(orgId).isEmpty()) return;

            int billSequence = 1;
            for (int i = 1; i <= CUSTOMER_COUNT; i++) {
                String customerName = "Customer " + i;
                customers.create(orgId, new CustomerRequest(customerName, "finance" + i + "@example.com", i % 3 == 0 ? "EUR" : "USD", i % 2 == 0 ? "Net 15" : "Net 30"));

                invoices.create(orgId, new InvoiceRequest(
                        customerName,
                        String.format("INV-2026-%04d", i),
                        new BigDecimal(1000 + (i * 13 % 9000)),
                        LocalDate.now().minusDays(i % 45),
                        LocalDate.now().plusDays(30 - (i % 40)),
                        switch (i % 4) {
                            case 0 -> InvoiceStatus.PAID;
                            case 1 -> InvoiceStatus.SENT;
                            case 2 -> InvoiceStatus.OVERDUE;
                            default -> InvoiceStatus.DRAFT;
                        }
                ));

                for (int j = 1; j <= BILLS_PER_CUSTOMER; j++) {
                    int n = billSequence++;
                    bills.create(orgId, new BillRequest(
                            customerName + " Vendor " + j,
                            String.format("BILL-2026-%05d", n),
                            new BigDecimal(300 + (n * 11 % 6000)),
                            LocalDate.now().plusDays(20 - (n % 35)),
                            n % 5 == 0
                    ));
                }
            }
        };
    }
}
