package com.acme.accounting.common;

public final class TenantContext {
    private TenantContext() {}
    public static final String ORG_HEADER = "X-Org-Id";
    public static final String DEFAULT_ORG = "demo-org";
}
