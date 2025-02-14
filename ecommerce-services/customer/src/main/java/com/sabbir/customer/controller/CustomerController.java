package com.sabbir.customer.controller;

import com.sabbir.customer.model.dto.CustomerContactInfoDto;
import com.sabbir.customer.model.dto.CustomerDto;
import com.sabbir.customer.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/customer")
@Validated

public class CustomerController {
    private static final Logger logger =  LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private Environment env;

    @Autowired
    private CustomerContactInfoDto customerContactInfoDto;

    @PostMapping("/createCustomer")
    public ResponseEntity<Long> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerDto));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Boolean> updateCustomer(@Valid @RequestBody CustomerDto customerDto) {
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

//    @GetMapping("/fetchCustomer")
//    public ResponseEntity<CustomerDto> fetchCustomer(@RequestParam Long customerId) {
//        return ResponseEntity.status(HttpStatus.OK).body(customerService.fetchCustomer(customerId));
//    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerDto> fetchCustomer(@PathVariable("customer-id") Long customerId) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.fetchCustomer(customerId));
    }

    @GetMapping("/fetchCustomer/mobileNumber")
    public ResponseEntity<CustomerDto> fetchCustomerByMobileNumber(@RequestParam @Pattern(regexp = "[0-9]{11}") String mobileNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.fetchCustomer(mobileNumber));
    }


    @GetMapping("/build-info")
    public ResponseEntity<String > getBuildInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
    }
    @GetMapping("/java-info")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(env.getProperty("JAVA_HOME"));
    }

    @GetMapping("contact-info")
    public ResponseEntity<CustomerContactInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerContactInfoDto);
    }

}
