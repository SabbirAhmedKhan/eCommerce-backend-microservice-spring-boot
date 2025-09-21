package com.sabbir.order.model.dto;

import java.math.BigDecimal;

public record PaymentRequestDto (
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerResponseDto customer
) {}
