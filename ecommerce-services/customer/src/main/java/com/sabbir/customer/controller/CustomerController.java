package com.sabbir.customer.controller;

import com.sabbir.customer.model.dto.CustomerDto;
import com.sabbir.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/customer")

public class CustomerController {
    private static final Logger logger =  LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<Long> createCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerDto));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Boolean> updateCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(customerDto));
    }

    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<Boolean> deleteCustomer(String mobileNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.deleteCustomer(mobileNumber));
    }

    @GetMapping("/fetchCustomer/{mobileNumber}")
    public ResponseEntity<CustomerDto> fetchCustomer(@PathVariable String mobileNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.fetchCustomer(mobileNumber));
    }

    @GetMapping("/fetchCustomer")
    public ResponseEntity<CustomerDto> fetchCustomer(@RequestParam Long customerId) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.fetchCustomer(customerId));
    }
}
