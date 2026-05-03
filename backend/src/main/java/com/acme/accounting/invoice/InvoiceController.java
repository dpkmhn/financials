package com.acme.accounting.invoice;

import com.acme.accounting.common.TenantContext;
import com.acme.accounting.entity.InvoiceEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    private final InvoiceService service;
    public InvoiceController(InvoiceService service) { this.service = service; }

    @GetMapping public List<InvoiceEntity> list(@RequestHeader(value = TenantContext.ORG_HEADER, defaultValue = TenantContext.DEFAULT_ORG) String orgId) { return service.list(orgId); }
    @PostMapping public InvoiceEntity create(@RequestHeader(value = TenantContext.ORG_HEADER, defaultValue = TenantContext.DEFAULT_ORG) String orgId, @Valid @RequestBody InvoiceRequest request) { return service.create(orgId, request); }
}
