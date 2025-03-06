package com.sabbir.order.controller;

import com.sabbir.order.model.dto.OrderLineResponseDto;
import com.sabbir.order.service.CustomerLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer-line")
@RequiredArgsConstructor
public class CustomerLineController {
    private final CustomerLineService customerLineService;

    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderLineResponseDto>> findByOrderId(
            @PathVariable("order-id") Integer orderId) {
        return ResponseEntity.ok(customerLineService.findAllByOrderId(orderId));
    }
}
