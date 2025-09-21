package com.sabbir.order.service;

import com.sabbir.order.model.dto.OrderLineRequestDto;
import com.sabbir.order.model.dto.OrderLineResponseDto;

import java.util.List;

public interface CustomerLineService {
    Integer saveCustomerLine(OrderLineRequestDto orderLineRequestDto);
    List<OrderLineResponseDto> findAllByOrderId(Integer orderId); // returns id of customerLine
}
