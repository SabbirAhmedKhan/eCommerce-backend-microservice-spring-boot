package com.sabbir.customer.model.dto;

import com.sabbir.customer.model.entity.Address;

public record CustomerDto(String firstName,
                          String lastName,
                          String email,
                          String mobileNumber,
                          AddressDto address){

}
