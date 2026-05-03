package com.acme.accounting.dto;

import java.math.BigDecimal;
import java.util.List;

public record DashboardSummaryResponse(BigDecimal totalReceivables, BigDecimal overdueReceivables, BigDecimal totalPayables, BigDecimal overduePayables, List<CashFlowPoint> cashFlow) {
  public record CashFlowPoint(String month, BigDecimal incoming, BigDecimal outgoing) {}
}
