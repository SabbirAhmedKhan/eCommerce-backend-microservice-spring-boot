package com.sabbir.order.mapper;

import com.sabbir.order.model.dto.OrderRequestDto;
import com.sabbir.order.model.dto.OrderResponseDto;
import com.sabbir.order.model.entity.CustomerOrder;

public class OrderMapper {
    public static CustomerOrder mapToOrder(OrderRequestDto orderRequestDto) {
        return CustomerOrder.builder()
                .id(orderRequestDto.id())
                .reference(orderRequestDto.reference())
                //.totalAmount(orderRequestDto.amount())
                .paymentMethod(orderRequestDto.paymentMethod())
                .customerId(orderRequestDto.customerId())
                .build();
    }

    public static OrderResponseDto mapToOrderResponseDto(CustomerOrder customerOrder) {
        return new OrderResponseDto(customerOrder.getId(), customerOrder.getReference(), customerOrder.getTotalAmount(), customerOrder.getPaymentMethod(), customerOrder.getCustomerId());
    }
}
