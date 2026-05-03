package com.acme.accounting.entity;

import jakarta.persistence.*;

@Entity @Table(name = "customers")
public class CustomerEntity extends BaseOrgEntity {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false) private String name;
    @Column(nullable = false) private String email;
    @Column(nullable = false) private String currency;
    @Column(nullable = false) private String paymentTerms;
    public String getId() { return id; } public String getName() { return name; } public void setName(String name) { this.name = name; }
    public String getEmail() { return email; } public void setEmail(String email) { this.email = email; }
    public String getCurrency() { return currency; } public void setCurrency(String currency) { this.currency = currency; }
    public String getPaymentTerms() { return paymentTerms; } public void setPaymentTerms(String paymentTerms) { this.paymentTerms = paymentTerms; }
}
