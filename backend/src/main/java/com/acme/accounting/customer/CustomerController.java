package com.acme.accounting.customer;

import com.acme.accounting.common.TenantContext;
import com.acme.accounting.entity.CustomerEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;
    public CustomerController(CustomerService service) { this.service = service; }

    @GetMapping
    public List<CustomerEntity> list(@RequestHeader(value = TenantContext.ORG_HEADER, defaultValue = TenantContext.DEFAULT_ORG) String orgId) { return service.list(orgId); }
    @PostMapping
    public CustomerEntity create(@RequestHeader(value = TenantContext.ORG_HEADER, defaultValue = TenantContext.DEFAULT_ORG) String orgId, @Valid @RequestBody CustomerRequest request) { return service.create(orgId, request); }
}
