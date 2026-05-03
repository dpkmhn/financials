package com.acme.accounting.repository;

import com.acme.accounting.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, String> { List<InvoiceEntity> findByOrgId(String orgId); }
