package com.sabbir.payment.model.dto;

import java.math.BigDecimal;

public record PaymentRequestDto(Integer id,
                                BigDecimal amount,
                                PaymentMethod paymentMethod,
                                Integer orderId,
                                String orderReference,
                                CustomerDto customerDto) {
}
