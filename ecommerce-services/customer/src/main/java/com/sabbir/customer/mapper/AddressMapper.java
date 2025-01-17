package com.sabbir.customer.mapper;

import com.sabbir.customer.model.dto.AddressDto;
import com.sabbir.customer.model.entity.Address;

public class AddressMapper {
    public static Address mapToAddress(AddressDto addressDto) {
        return Address.builder()
                .houseNumber(addressDto.houseNumber())
                .roadNumber(addressDto.roadNumber())
                .zipCode(addressDto.zipCode())
                .build();
    }

    public static AddressDto mapToAddressDto(Address address) {
        return new AddressDto(address.getHouseNumber(), address.getRoadNumber(), address.getZipCode());
    }
}
