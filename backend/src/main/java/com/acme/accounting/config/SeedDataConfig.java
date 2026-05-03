package com.acme.accounting.config;

import com.acme.accounting.dto.Requests.*;
import com.acme.accounting.entity.InvoiceStatus;
import com.acme.accounting.service.AccountingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class SeedDataConfig {
  @Bean CommandLineRunner seed(AccountingService s){
    return args -> {
      if (!s.listCustomers("demo-org").isEmpty()) return;
      s.createCustomer("demo-org", new CreateCustomerRequest("Skyline Retail","ap@skyline.com","USD","Net 30"));
      s.createInvoice("demo-org", new CreateInvoiceRequest("Skyline Retail","INV-2026-001",new BigDecimal("7400"),LocalDate.now().minusDays(20),LocalDate.now().minusDays(2), InvoiceStatus.OVERDUE));
      s.createBill("demo-org", new CreateBillRequest("AWS","BILL-100",new BigDecimal("2200"),LocalDate.now().plusDays(4),false));
    };
  }
}
