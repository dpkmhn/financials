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
    @Bean
    CommandLineRunner seed(CustomerService customers, InvoiceService invoices, BillService bills) {
        return args -> {
            String orgId = "demo-org";
            if (!customers.list(orgId).isEmpty()) return;
            customers.create(orgId, new CustomerRequest("Skyline Retail", "ap@skyline.com", "USD", "Net 30"));
            invoices.create(orgId, new InvoiceRequest("Skyline Retail", "INV-2026-001", new BigDecimal("7400"), LocalDate.now().minusDays(20), LocalDate.now().minusDays(2), InvoiceStatus.OVERDUE));
            bills.create(orgId, new BillRequest("AWS", "BILL-100", new BigDecimal("2200"), LocalDate.now().plusDays(4), false));
        };
    }
}
