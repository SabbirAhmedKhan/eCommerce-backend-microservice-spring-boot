package com.sabbir.payment.model.dto;

import java.math.BigDecimal;

public record PaymentNotificationRequestDto(

        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstname,
        String customerLastname,
        String customerEmail
) {
}
