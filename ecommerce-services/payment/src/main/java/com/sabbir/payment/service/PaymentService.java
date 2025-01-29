package com.sabbir.payment.service;

import com.sabbir.payment.model.dto.PaymentRequestDto;

public interface PaymentService {
    Integer createPayment(PaymentRequestDto request);
}
