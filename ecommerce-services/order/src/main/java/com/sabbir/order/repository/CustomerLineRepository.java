package com.sabbir.order.repository;

import com.sabbir.order.model.entity.CustomerLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerLineRepository extends JpaRepository<CustomerLine, Integer> {
}
