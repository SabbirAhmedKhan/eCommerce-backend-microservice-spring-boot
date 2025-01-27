package com.sabbir.order.mapper;

import com.sabbir.order.model.dto.OrderLineRequestDto;
import com.sabbir.order.model.dto.OrderLineResponseDto;
import com.sabbir.order.model.entity.CustomerLine;
import com.sabbir.order.model.entity.CustomerOrder;

public class OrderLineMapper {
    public static CustomerLine mapToOrderLine(OrderLineRequestDto orderLineRequestDto) {
        return CustomerLine.builder()
                .id(orderLineRequestDto.orderId())
                .productId(orderLineRequestDto.productId())
                .customerOrder(
                        CustomerOrder.builder()
                                .id(orderLineRequestDto.orderId())
                                .build()
                )
                .quantity(orderLineRequestDto.quantity())
                .build();
    }

    public static OrderLineResponseDto mapToOrderLineResponseDto(CustomerLine customerLine) {
        return new OrderLineResponseDto(
                customerLine.getId(),
                customerLine.getQuantity()
        );
    }
}
