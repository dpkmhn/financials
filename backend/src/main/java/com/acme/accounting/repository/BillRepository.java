package com.acme.accounting.repository;

import com.acme.accounting.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BillRepository extends JpaRepository<BillEntity, String> { List<BillEntity> findByOrgId(String orgId); }
