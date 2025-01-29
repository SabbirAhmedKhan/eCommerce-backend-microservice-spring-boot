package com.sabbir.order.service.impl;

import com.sabbir.order.model.dto.OrderRequestDto;
import com.sabbir.order.model.dto.OrderResponseDto;
import com.sabbir.order.service.CustomerOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
    @Override
    public Integer createOrder(OrderRequestDto orderRequestDto) {
        return 0;
    }

    @Override
    public List<OrderResponseDto> findAllCustomerOrder() {
        return List.of();
    }

    @Override
    public OrderResponseDto findCustomerOrderById(Integer id) {
        return null;
    }
}
