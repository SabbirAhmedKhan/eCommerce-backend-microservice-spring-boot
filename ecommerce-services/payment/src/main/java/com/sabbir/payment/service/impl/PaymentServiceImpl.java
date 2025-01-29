package com.sabbir.payment.service.impl;

import com.sabbir.payment.mapper.PaymentMapper;
import com.sabbir.payment.model.dto.PaymentRequestDto;
import com.sabbir.payment.repository.PaymentRepository;
import com.sabbir.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    @Override
    public Integer createPayment(PaymentRequestDto request) {
        var payment = paymentRepository.save(PaymentMapper.mapToPayment(request));

//        this.notificationProducer.sendNotification(
//                new PaymentNotificationRequest(
//                        request.orderReference(),
//                        request.amount(),
//                        request.paymentMethod(),
//                        request.customer().firstname(),
//                        request.customer().lastname(),
//                        request.customer().email()
//                )
//        );

        return payment.getId();
    }
}
