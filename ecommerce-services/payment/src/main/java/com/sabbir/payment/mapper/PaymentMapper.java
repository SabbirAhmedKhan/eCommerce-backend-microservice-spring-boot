package com.sabbir.payment.mapper;

import com.sabbir.payment.model.dto.PaymentMethod;
import com.sabbir.payment.model.dto.PaymentRequestDto;
import com.sabbir.payment.model.entity.Payment;
import jakarta.validation.constraints.Null;

public class PaymentMapper {
    public static Payment mapToPayment(PaymentRequestDto paymentRequestDto) {
        if(paymentRequestDto == null) {
            return null;
        }
        return Payment.builder()
                .id(paymentRequestDto.id())
                .amount(paymentRequestDto.amount())
                .paymentMethod(paymentRequestDto.paymentMethod())
                .orderId(paymentRequestDto.orderId())
                .build();
    }
}
