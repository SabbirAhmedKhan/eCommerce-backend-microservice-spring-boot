package com.sabbir.customer.service;

import com.sabbir.customer.model.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    Long createCustomer(CustomerDto customerDto);

    CustomerDto fetchCustomer(String mobileNumber);

    CustomerDto fetchCustomer(Long customerId);

    List<CustomerDto> fetchAllCustomers(); <T>

    Boolean updateCustomer(CustomerDto customerDto);

    Boolean deleteCustomer(String mobileNumber);
}
