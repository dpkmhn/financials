package com.acme.accounting.bill;

import com.acme.accounting.common.TenantContext;
import com.acme.accounting.entity.BillEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {
    private final BillService service;
    public BillController(BillService service) { this.service = service; }
    @GetMapping public List<BillEntity> list(@RequestHeader(value = TenantContext.ORG_HEADER, defaultValue = TenantContext.DEFAULT_ORG) String orgId) { return service.list(orgId); }
    @PostMapping public BillEntity create(@RequestHeader(value = TenantContext.ORG_HEADER, defaultValue = TenantContext.DEFAULT_ORG) String orgId, @Valid @RequestBody BillRequest request) { return service.create(orgId, request); }
}
