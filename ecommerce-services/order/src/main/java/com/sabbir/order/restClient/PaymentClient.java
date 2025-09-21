package com.sabbir.order.restClient;


import com.sabbir.order.model.dto.PaymentRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("payment")
public interface PaymentClient {
    @PostMapping("/api/v1/payments")
    Integer payment(@RequestBody PaymentRequestDto paymentRequestDto);
}
