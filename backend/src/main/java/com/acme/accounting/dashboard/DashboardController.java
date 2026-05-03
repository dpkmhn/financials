package com.acme.accounting.dashboard;

import com.acme.accounting.common.TenantContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public DashboardSummaryResponse summary(@RequestHeader(value = TenantContext.ORG_HEADER, defaultValue = TenantContext.DEFAULT_ORG) String orgId) {
        return dashboardService.getSummary(orgId);
    }
}
