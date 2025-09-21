package com.sabbir.order.model.dto;

public record OrderLineRequestDto(Integer id,
                                  Integer orderId,
                                  Integer productId,
                                  double quantity) { }
