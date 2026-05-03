package com.acme.accounting.dashboard;

import com.acme.accounting.entity.BillEntity;
import com.acme.accounting.entity.InvoiceEntity;
import com.acme.accounting.entity.InvoiceStatus;
import com.acme.accounting.repository.BillRepository;
import com.acme.accounting.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class DashboardService {
    private final InvoiceRepository invoiceRepository;
    private final BillRepository billRepository;

    public DashboardService(InvoiceRepository invoiceRepository, BillRepository billRepository) {
        this.invoiceRepository = invoiceRepository;
        this.billRepository = billRepository;
    }

    public DashboardSummaryResponse getSummary(String orgId) {
        List<InvoiceEntity> invoices = invoiceRepository.findByOrgId(orgId);
        List<BillEntity> bills = billRepository.findByOrgId(orgId);

        BigDecimal receivables = invoices.stream().filter(i -> i.getStatus() != InvoiceStatus.PAID).map(InvoiceEntity::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal overdueReceivables = invoices.stream().filter(i -> i.getStatus() == InvoiceStatus.OVERDUE).map(InvoiceEntity::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal payables = bills.stream().filter(b -> !b.isPaid()).map(BillEntity::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal overduePayables = bills.stream().filter(b -> !b.isPaid() && b.getDueDate().isBefore(LocalDate.now())).map(BillEntity::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);

        var cashFlow = List.of(
                new DashboardSummaryResponse.CashFlowPoint("Jan", bd("42000"), bd("30000")),
                new DashboardSummaryResponse.CashFlowPoint("Feb", bd("47000"), bd("34500")),
                new DashboardSummaryResponse.CashFlowPoint("Mar", bd("51000"), bd("37000"))
        );

        return new DashboardSummaryResponse(receivables, overdueReceivables, payables, overduePayables, cashFlow);
    }

    private BigDecimal bd(String value) { return new BigDecimal(value); }
}
