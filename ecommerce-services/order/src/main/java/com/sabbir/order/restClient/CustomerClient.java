package com.sabbir.order.restClient;

import com.sabbir.order.model.dto.CustomerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

//@FeignClient(
//        name = "customer-service",
//        url = "${application.config.customer-url}" //TODO: update
//)
@FeignClient("customer")
public interface CustomerClient {

    @GetMapping("/api/v1/customer/{customer-id}")
    Optional<CustomerResponseDto> fetchCustomer(@PathVariable("customer-id") Long customerId);
}
