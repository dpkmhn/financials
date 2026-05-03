package com.acme.accounting.service;

import com.acme.accounting.dto.DashboardSummaryResponse;
import com.acme.accounting.dto.Requests.*;
import com.acme.accounting.entity.*;
import com.acme.accounting.repository.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class AccountingService {
  private final CustomerRepository customers; private final InvoiceRepository invoices; private final BillRepository bills;
  public AccountingService(CustomerRepository c, InvoiceRepository i, BillRepository b){customers=c;invoices=i;bills=b;}

  public List<CustomerEntity> listCustomers(String orgId){ return customers.findByOrgId(orgId); }
  public List<InvoiceEntity> listInvoices(String orgId){ return invoices.findByOrgId(orgId); }
  public List<BillEntity> listBills(String orgId){ return bills.findByOrgId(orgId); }

  public CustomerEntity createCustomer(String orgId, CreateCustomerRequest r){ var e=new CustomerEntity(); e.setOrgId(orgId); e.setName(r.name()); e.setEmail(r.email()); e.setCurrency(r.currency()); e.setPaymentTerms(r.paymentTerms()); return customers.save(e);} 
  public InvoiceEntity createInvoice(String orgId, CreateInvoiceRequest r){ var e=new InvoiceEntity(); e.setOrgId(orgId); e.setCustomerName(r.customerName()); e.setInvoiceNumber(r.invoiceNumber()); e.setAmount(r.amount()); e.setIssueDate(r.issueDate()); e.setDueDate(r.dueDate()); e.setStatus(r.status()); return invoices.save(e);} 
  public BillEntity createBill(String orgId, CreateBillRequest r){ var e=new BillEntity(); e.setOrgId(orgId); e.setVendor(r.vendor()); e.setBillNumber(r.billNumber()); e.setAmount(r.amount()); e.setDueDate(r.dueDate()); e.setPaid(r.paid()); return bills.save(e);} 

  public DashboardSummaryResponse dashboard(String orgId){
    var inv=listInvoices(orgId); var bl=listBills(orgId);
    BigDecimal receivables=inv.stream().filter(i->i.getStatus()!=InvoiceStatus.PAID).map(InvoiceEntity::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    BigDecimal overdueReceivables=inv.stream().filter(i->i.getStatus()==InvoiceStatus.OVERDUE).map(InvoiceEntity::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    BigDecimal payables=bl.stream().filter(i->!i.isPaid()).map(BillEntity::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    BigDecimal overduePayables=bl.stream().filter(i->!i.isPaid() && i.getDueDate().isBefore(LocalDate.now())).map(BillEntity::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    var cash=List.of(new DashboardSummaryResponse.CashFlowPoint("Jan",bd("42000"),bd("30000")),new DashboardSummaryResponse.CashFlowPoint("Feb",bd("47000"),bd("34500")),new DashboardSummaryResponse.CashFlowPoint("Mar",bd("51000"),bd("37000")));
    return new DashboardSummaryResponse(receivables, overdueReceivables, payables, overduePayables, cash);
  }
  private BigDecimal bd(String n){ return new BigDecimal(n); }
}
