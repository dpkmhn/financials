package com.acme.accounting.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity @Table(name="bills")
public class BillEntity extends BaseOrgEntity {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private String id;
    @Column(nullable = false) private String vendor;
    @Column(nullable = false, unique = true) private String billNumber;
    @Column(nullable = false) private BigDecimal amount;
    private LocalDate dueDate; private boolean paid;
    public String getId(){return id;} public String getVendor(){return vendor;} public void setVendor(String v){vendor=v;}
    public String getBillNumber(){return billNumber;} public void setBillNumber(String v){billNumber=v;}
    public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal v){amount=v;}
    public LocalDate getDueDate(){return dueDate;} public void setDueDate(LocalDate v){dueDate=v;}
    public boolean isPaid(){return paid;} public void setPaid(boolean v){paid=v;}
}
