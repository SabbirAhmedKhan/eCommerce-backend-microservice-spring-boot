package com.sabbir.order.controller;

import com.sabbir.order.model.dto.OrderRequestDto;
import com.sabbir.order.model.dto.OrderResponseDto;
import com.sabbir.order.service.CustomerOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer-order")
@RequiredArgsConstructor
public class CustomerOrderController {
    private final CustomerOrderService customerOrderService;

    @PostMapping("/createOrder")
    public ResponseEntity<Integer> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerOrderService.createOrder(orderRequestDto));
    }

    @GetMapping("/findAllCustomerOrder")
    public ResponseEntity<List<OrderResponseDto>> findAllCustomerOrder() {
        return ResponseEntity.ok(customerOrderService.findAllCustomerOrder());
    }

    @GetMapping("{order-id}")
    public ResponseEntity<OrderResponseDto> findbyOrderId(
            @PathVariable("order-id") Integer orderId
    ) {
        return ResponseEntity.ok(customerOrderService.findCustomerOrderById(orderId));
    }
}
