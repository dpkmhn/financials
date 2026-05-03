package com.acme.accounting.controller;

import com.acme.accounting.dto.DashboardSummaryResponse;
import com.acme.accounting.dto.Requests.*;
import com.acme.accounting.entity.*;
import com.acme.accounting.service.AccountingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api")
public class AccountingController {
  private final AccountingService service;
  public AccountingController(AccountingService service){this.service=service;}
  @GetMapping("/dashboard") public DashboardSummaryResponse dashboard(@RequestHeader(value="X-Org-Id", defaultValue="demo-org") String orgId){ return service.dashboard(orgId);} 
  @GetMapping("/customers") public List<CustomerEntity> customers(@RequestHeader(value="X-Org-Id", defaultValue="demo-org") String orgId){ return service.listCustomers(orgId);} 
  @PostMapping("/customers") public CustomerEntity createCustomer(@RequestHeader(value="X-Org-Id", defaultValue="demo-org") String orgId, @Valid @RequestBody CreateCustomerRequest request){ return service.createCustomer(orgId, request);} 
  @GetMapping("/invoices") public List<InvoiceEntity> invoices(@RequestHeader(value="X-Org-Id", defaultValue="demo-org") String orgId){ return service.listInvoices(orgId);} 
  @PostMapping("/invoices") public InvoiceEntity createInvoice(@RequestHeader(value="X-Org-Id", defaultValue="demo-org") String orgId, @Valid @RequestBody CreateInvoiceRequest request){ return service.createInvoice(orgId, request);} 
  @GetMapping("/bills") public List<BillEntity> bills(@RequestHeader(value="X-Org-Id", defaultValue="demo-org") String orgId){ return service.listBills(orgId);} 
  @PostMapping("/bills") public BillEntity createBill(@RequestHeader(value="X-Org-Id", defaultValue="demo-org") String orgId, @Valid @RequestBody CreateBillRequest request){ return service.createBill(orgId, request);} 
}
