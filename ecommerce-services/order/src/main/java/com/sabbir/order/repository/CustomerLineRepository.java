package com.sabbir.order.repository;

import com.sabbir.order.model.entity.CustomerLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerLineRepository extends JpaRepository<CustomerLine, Integer> {
    List<CustomerLine> findAllByOrderId(Integer orderId); // <1>
}
