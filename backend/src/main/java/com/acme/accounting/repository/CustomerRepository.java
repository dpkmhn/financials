package com.acme.accounting.repository;

import com.acme.accounting.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> { List<CustomerEntity> findByOrgId(String orgId); }
