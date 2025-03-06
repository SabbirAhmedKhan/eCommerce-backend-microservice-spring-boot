package com.sabbir.order.messageBroker;

import com.sabbir.order.model.dto.CustomerResponseDto;
import com.sabbir.order.model.dto.PaymentMethod;
import com.sabbir.order.model.dto.PurchaseResponseDto;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponseDto customer,
        List<PurchaseResponseDto> products

) {
}
