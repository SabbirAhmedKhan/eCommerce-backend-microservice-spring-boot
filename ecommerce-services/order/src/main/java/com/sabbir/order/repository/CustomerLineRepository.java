package com.sabbir.order.repository;

import com.sabbir.order.model.entity.CustomerLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerLineRepository extends JpaRepository<CustomerLine, Integer> {
    List<CustomerLine> findAllByCustomerOrderId(Integer customerOrderId); // <1>
}
