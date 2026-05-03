package com.acme.accounting.bill;

import com.acme.accounting.entity.BillEntity;
import com.acme.accounting.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    private final BillRepository repository;
    public BillService(BillRepository repository) { this.repository = repository; }
    public List<BillEntity> list(String orgId) { return repository.findByOrgId(orgId); }
    public BillEntity create(String orgId, BillRequest request) {
        BillEntity entity = new BillEntity();
        entity.setOrgId(orgId); entity.setVendor(request.vendor()); entity.setBillNumber(request.billNumber()); entity.setAmount(request.amount()); entity.setDueDate(request.dueDate()); entity.setPaid(request.paid());
        return repository.save(entity);
    }
}
