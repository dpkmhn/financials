package com.acme.accounting.invoice;

import com.acme.accounting.entity.InvoiceEntity;
import com.acme.accounting.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository repository;
    public InvoiceService(InvoiceRepository repository) { this.repository = repository; }
    public List<InvoiceEntity> list(String orgId) { return repository.findByOrgId(orgId); }
    public InvoiceEntity create(String orgId, InvoiceRequest request) {
        InvoiceEntity entity = new InvoiceEntity();
        entity.setOrgId(orgId); entity.setCustomerName(request.customerName()); entity.setInvoiceNumber(request.invoiceNumber());
        entity.setAmount(request.amount()); entity.setIssueDate(request.issueDate()); entity.setDueDate(request.dueDate()); entity.setStatus(request.status());
        return repository.save(entity);
    }
}
