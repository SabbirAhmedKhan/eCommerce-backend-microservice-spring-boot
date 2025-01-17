package com.sabbir.customer.service;

import com.sabbir.customer.model.dto.CustomerDto;

public interface CustomerService {
    Long createCustomer(CustomerDto customerDto);

    CustomerDto fetchCustomer(String mobileNumber);

    CustomerDto fetchCustomer(Long customerId);

    Boolean updateCustomer(CustomerDto customerDto);

    Boolean deleteCustomer(String mobileNumber);
}
