package com.acme.accounting.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity @Table(name="invoices")
public class InvoiceEntity extends BaseOrgEntity {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private String id;
    @Column(nullable = false) private String customerName;
    @Column(nullable = false, unique = true) private String invoiceNumber;
    @Column(nullable = false) private BigDecimal amount;
    private LocalDate issueDate; private LocalDate dueDate;
    @Enumerated(EnumType.STRING) private InvoiceStatus status;
    public String getId(){return id;} public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
    public String getInvoiceNumber(){return invoiceNumber;} public void setInvoiceNumber(String v){invoiceNumber=v;}
    public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal v){amount=v;}
    public LocalDate getIssueDate(){return issueDate;} public void setIssueDate(LocalDate v){issueDate=v;}
    public LocalDate getDueDate(){return dueDate;} public void setDueDate(LocalDate v){dueDate=v;}
    public InvoiceStatus getStatus(){return status;} public void setStatus(InvoiceStatus v){status=v;}
}
