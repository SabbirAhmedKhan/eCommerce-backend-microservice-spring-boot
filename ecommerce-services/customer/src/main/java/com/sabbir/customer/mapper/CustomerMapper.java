package com.sabbir.customer.mapper;

import com.sabbir.customer.model.dto.CustomerDto;
import com.sabbir.customer.model.entity.Customer;

public class CustomerMapper {
    public static Customer mapToCustomer(CustomerDto customerDto) {
        return Customer.builder()
                .firstName(customerDto.firstName())
                .lastName(customerDto.lastName())
                .email(customerDto.email())
                .mobileNumber(customerDto.mobileNumber())
                .address(AddressMapper.mapToAddress(customerDto.address()))
                .build();
    }

    public static CustomerDto mapToCustomerDto(Customer customer) {
        return new CustomerDto(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getMobileNumber(), AddressMapper.mapToAddressDto(customer.getAddress()));
    }

}
