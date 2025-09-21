package com.sabbir.order.service;

import com.sabbir.order.model.dto.CustomerResponseDto;
import com.sabbir.order.model.dto.OrderRequestDto;
import com.sabbir.order.model.dto.OrderResponseDto;

import java.util.List;

public interface CustomerOrderService {
    public Integer createOrder(OrderRequestDto orderRequestDto);
    List<OrderResponseDto> findAllCustomerOrder();
    OrderResponseDto findCustomerOrderById(Integer id);
    CustomerResponseDto findCustomer(Long id);

}
