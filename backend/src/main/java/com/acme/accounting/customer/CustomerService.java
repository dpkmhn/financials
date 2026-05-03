package com.acme.accounting.customer;

import com.acme.accounting.entity.CustomerEntity;
import com.acme.accounting.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;
    public CustomerService(CustomerRepository repository) { this.repository = repository; }

    public List<CustomerEntity> list(String orgId) { return repository.findByOrgId(orgId); }
    public CustomerEntity create(String orgId, CustomerRequest request) {
        CustomerEntity entity = new CustomerEntity();
        entity.setOrgId(orgId); entity.setName(request.name()); entity.setEmail(request.email());
        entity.setCurrency(request.currency()); entity.setPaymentTerms(request.paymentTerms());
        return repository.save(entity);
    }
}
