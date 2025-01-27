package com.sabbir.order.restClient;

import com.sabbir.order.model.dto.CustomerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer-service",
        url = "${application.config.customer-url}" //TODO: update
)
public interface CustomerClient {

    @GetMapping("/{customer-id}")
    Optional<CustomerResponseDto> fetchCustomer(@PathVariable("customer-id") Long customerId);
}
